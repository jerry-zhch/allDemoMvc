package com.ucmed.utils;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 工具类，http链接池
 * Created by 谢伟刚 on 2018/05/07.
 */
public class HttpUtil {
    private static final int maxTotal = 200; // 最大连接数
    private static final int defaultMaxPerRoute = 100; // 每个路由的最大连接数
    private static final int connectTimeout = 60000; // 连接超时时间
    private static final int socketTimeout = 60000; // 读取超时时间
    private static final int requestTimeout = 5000; // 从池中获取连接超时时间
    private static CloseableHttpClient httpclient = null;
    private static HttpUtil mInstance;

    public static HttpUtil getInstance() {
        if (mInstance == null) {
            mInstance = new HttpUtil();
            mInstance.init();
        }
        return mInstance;
    }

    /**
     * 初始化client对象
     */
    public void init() {
        if (httpclient != null) {
            return;
        }
        // 创建连接管理器
        PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager();
        // 设置最大连接数
        connMgr.setMaxTotal(maxTotal);
        // 设置每个路由的最大连接数
        connMgr.setDefaultMaxPerRoute(defaultMaxPerRoute);
        // 创建httpClient
        httpclient = HttpClients.custom().setConnectionManager(connMgr).build();
    }

    /**
     * 关闭连接池
     */
    public void close() {
        if (httpclient != null) {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 统一请求方式
     */
    public String getResopnse(HttpRequestBase request) {
        // 设置请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(connectTimeout) // 连接超时时间
                .setSocketTimeout(socketTimeout) // 读取超时时间（等待数据超时时间）
                .setConnectionRequestTimeout(requestTimeout) // 从池中获取连接超时时间
                .build();
        request.setConfig(requestConfig);
        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(request, HttpClientContext.create());
            // 转换结果
            HttpEntity entity = response.getEntity();
            String html = EntityUtils.toString(entity, "UTF-8");
            // 消费掉内容
            EntityUtils.consume(entity);
            return html;
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            request.releaseConnection();
        }
        return "";
    }

    /**
     * Get方式取得URL的内容
     */
    public String GET(String url) {
        HttpGet httpGet = new HttpGet(url);
        return getResopnse(httpGet);
    }

    /**
     * Post方式取得URL的内容
     */
    public String POST(String url, String content) {
        return POST(url, content, "application/json");
    }

    /**
     * Post方式取得URL的内容，charset为UTF-8
     */
    public String POST(String url, String content, String contentType) {
        return POST(url, content, contentType, "UTF-8");
    }

    /**
     * Post方式取得URL的内容，默认为"application/x-www-form-urlencoded"格式，charset为UTF-8
     */
    public String POST(String url, String content, String contentType, String charset) {
        HttpPost httpPost = new HttpPost(url);
        // 设置内容
        ContentType type = ContentType.create(contentType, Charset.forName(charset));
        StringEntity reqEntity = new StringEntity(content, type);
        httpPost.setEntity(reqEntity);
        return getResopnse(httpPost);
    }

    /**
     * 表单形式，Post方式取得URL的内容
     */
    public String HeaderQueryPOST(String url, Map<String, Object> header, Map<String, Object> query) {
        HttpPost httpPost = new HttpPost(url);
        for (Map.Entry<String, Object> entry : header.entrySet()) {
            String key = entry.getKey();
            String value = String.valueOf(entry.getValue());
            httpPost.addHeader(key, value);
        }
        ArrayList<BasicNameValuePair> pairs = new ArrayList<BasicNameValuePair>();
        for (Map.Entry<String, Object> entry : query.entrySet()) {
            String key = entry.getKey();
            String value = String.valueOf(entry.getValue());
            pairs.add(new BasicNameValuePair(key, value));
        }
        if (pairs != null) {
            try {
                UrlEncodedFormEntity formEntity;
                formEntity = new UrlEncodedFormEntity(pairs, "utf-8");
                httpPost.setEntity(formEntity);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return getResopnse(httpPost);
    }

    /**
     * Get方式取得URL的内容
     */
    public String HeaderQueryGET(String url, Map<String, Object> header, Map<String, Object> query) {
        int k = 0;
        for (Map.Entry<String, Object> entry : query.entrySet()) {
            String key = entry.getKey();
            String value = String.valueOf(entry.getValue());
            if (k++ == 0) {
                url += "?" + key + "=" + value;
            } else {
                url += "&" + key + "=" + value;
            }
        }
        HttpGet httpGet = new HttpGet(url);
        for (Map.Entry<String, Object> entry : header.entrySet()) {
            String key = entry.getKey();
            String value = String.valueOf(entry.getValue());
            httpGet.addHeader(key, value);
        }
        // 设置内容
        return getResopnse(httpGet);
    }

    public static void main(String[] args) {
        JSONObject req = new JSONObject();
        req.put("TX", "G002028");
        req.put("T", "0");
        req.put("D", "app");
        req.put("V", "1.0.0");
        req.put("parent_code", "999999");
        Map header = new HashMap();
        header.put("K", "ZW5sNWVWOWhibVJ5YjJsaw==");
        Map query = new HashMap();
        query.put("requestData", req.toString());
//        String resString = HttpUtil.getInstance().HeaderQueryPOST("http://localhost:8080/api/exec/1.htm", header, query);
        String resString = HttpUtil.getInstance().HeaderQueryPOST("http://hensrmyy.zwjk.com/api/exec/1.htm", header, query);
        System.out.println(resString);
    }
}