package com.ucmed.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HttpReq {
    private static final Logger logger=Logger.getLogger("HttpReq");

    public static String sendGet(String url) {

        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            // for (String key : map.keySet()) {
            // System.out.println(key + "--->" + map.get(key));
            // }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while((line = in.readLine()) != null) {
                result += line;
            }
        } catch(Exception e) {
            logger.info("sendGet==>error==>"+e);
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if(in != null) {
                    in.close();
                }
            } catch(Exception e2) {
                logger.info("sendGet==>error22==>"+e2);
            }
        }
        return result;
    }

    public static String sendPost(String obj,String url) {
        StringEntity re = null;
        try {
            HttpClient httpClient= HttpClientBuilder.create().build();

            HttpPost httpPost=new HttpPost(url);
            httpPost.setHeader("Content-Type","text/xml;charset=GBK");
            re=new StringEntity(obj,"UTF-8");
//            re.setContentEncoding("GBK");
            httpPost.setEntity(re);
            HttpResponse response=httpClient.execute(httpPost);
            if (response!=null && response.getStatusLine().getStatusCode()==200) {
                return EntityUtils.toString(response.getEntity(),"UTF-8");
            }
        } catch (Exception e) {
            logger.info("sendPost==>error==>" + e);
        } finally {
            try {
                if (null != re) {
                    re.consumeContent();
                }
            } catch (IOException e) {
            }
        }
        return null;
    }
}
