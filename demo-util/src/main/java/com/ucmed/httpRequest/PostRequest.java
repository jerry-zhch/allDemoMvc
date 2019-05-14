package com.ucmed.httpRequest;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PostRequest {
//    private static final String url="http://192.168.0.10:8888/order/saveBRDA";
    private static final String url="http://localhost:9993/order/getDeptList.htm";

    public static void main(String[] args) {
        JSONObject req=new JSONObject();
        req.put("hospitalId","33010410");
        req.put("deptName","庆");

        System.out.println(request(req));

//        long s=System.currentTimeMillis();
//        com.ucmed.httpRequest.HttpClient httpClient=new com.ucmed.httpRequest.HttpClient(url);
//        System.out.println(httpClient.sendSynchronousRequest(req.toString()));
//        System.out.println("c:"+(System.currentTimeMillis()-s));

    }

    public static String request(JSONObject req) {
        long start=System.currentTimeMillis();
        HttpEntity re = null;
        try {
            HttpClient httpClient= HttpClientBuilder.create().build();
            System.out.println("1:"+(System.currentTimeMillis()-start));
            HttpPost httppost = new HttpPost(url);

            System.out.println("2:"+(System.currentTimeMillis()-start));
            // 创建参数队列
            List<NameValuePair> nvps = new ArrayList<>();

            for (Object o:req.keySet()){
                String key=o.toString();
                nvps.add(new BasicNameValuePair(key, req.optString(key)));
            }

            System.out.println("3:"+(System.currentTimeMillis()-start));
            httppost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
            HttpResponse response=httpClient.execute(httppost);

            System.out.println("4:"+(System.currentTimeMillis()-start));
            re = response.getEntity();
            if (response.getStatusLine().getStatusCode() == 200) {

                System.out.println("15:"+(System.currentTimeMillis()-start));
                return EntityUtils.toString(response.getEntity(),"utf-8");
            }
        } catch (Exception e) {
            System.out.println("RequestQZnew==>request==>error==>" + e);
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
