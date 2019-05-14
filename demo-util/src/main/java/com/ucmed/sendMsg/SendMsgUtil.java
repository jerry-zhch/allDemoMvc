package com.ucmed.sendMsg;

import net.sf.json.JSONObject;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class SendMsgUtil {
    private static final Logger LOG = Logger.getLogger("SendMsgUtil");

    private static String url = "http://sendMsg.zwjk.com:8888/api/exec/1.htm";
    private static String key = "ZW5sNWVWOWhibVJ5YjJsaw==";

    public static void main(String[] args) {
        JSONObject req=new JSONObject();
        req.put("sendMsg","1111111");
        req.put("phone","13397155127");
        System.out.println(httpRequest(req));
    }

//    static {
//        Properties prop = new Properties();
//        InputStream in;
//        try {
//            in = SendMsgUtil.class.getResourceAsStream("/configure.properties");
//            prop.load(in);
//            url = prop.getProperty("sendMsg.url","http://msg.zwjk.com:8888/api/exec/1.htm");
//            key = prop.getProperty("sendMsg.key","ZW5sNWVWOWhibVJ5YjJsaw==");
//        } catch(Exception e) {
//            LOG.info("SendMsgUtil==>static==>error==>"+e);
//        }
//    }

    public static JSONObject httpRequest(JSONObject req) {
        LOG.info("SendMsg request data is >>>>>>>>>>>>>>>>>>>>>>>>"+ req.toString());
        req.put("TX", "SendMsg");
        req.put("V", "1.0");
        req.put("T", "0");
        req.put("D", "All");
        JSONObject res = new JSONObject();
        String mUrl = url;
        ArrayList<BasicNameValuePair> pairs = new ArrayList<BasicNameValuePair>();
        pairs.add(new BasicNameValuePair("requestData", req.toString()));
        UrlEncodedFormEntity entity = null;
        HttpRequest httpRequest = null;
        HttpResponse response = null;
        HttpHost target = null;
        String resStr = null;
        try {
            URL url = getURL();
            String protocol = url.getProtocol();
            int port = url.getPort();
            if(port == -1)
                port = url.getDefaultPort();
            target = new HttpHost(url.getHost(), port, protocol);
            if(pairs != null) {
                httpRequest = new HttpPost(mUrl);
                entity = new UrlEncodedFormEntity(pairs, "utf-8");
                ((HttpPost) httpRequest).setEntity(entity);
            }
            httpRequest.addHeader("K", key);
            httpRequest.addHeader("Content-type","application/x-www-form-urlencoded;charset=utf-8");
            httpRequest.addHeader("Accept","application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
//            HttpClient httpClient= HttpClientBuilder.create().build();
            response = HttpConnectionManager.getHttpClient().execute(target, httpRequest);
//            response = httpClient.execute(target, httpRequest);

            if(response != null&& response.getStatusLine().getStatusCode() == 200) {
                resStr = EntityUtils.toString(response.getEntity());
            }
            LOG.info("SendMsg return data is <<<<<<<<<<<<<<<<<<<<<<<<<<" + resStr);
        } catch(Exception e) {
            LOG.error("SendMsg error ==>" + e);
        } finally {
            if(response != null) {
                try {
                    EntityUtils.consume(response.getEntity());// 会自动释放连接
                } catch(IOException e) {
                    LOG.error("SendMsg finally error==>" + e);
                }
            }
        }
        if(null == resStr) {
            res.put("R", "-1");
            res.put("I", "未知错误，返回为空");
            return res;
        }
        return JSONObject.fromObject(resStr);
    }

    private static URL getURL() {
        URL qz_url = null;
        try {
            qz_url = new URL(url);
        } catch(Exception e) {
            LOG.info("sendMsgUtil==>getURL==>error==>"+e);
        }
        return qz_url;
    }

}