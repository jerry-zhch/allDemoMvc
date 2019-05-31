package com.juntaihc;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class RequestForZyy {

    public static String requestWebservie(String req,String url,String soapAction){
        HttpEntity entity=null;
        try {
            HttpClient client= HttpClientBuilder.create().build();

            HttpPost post=new HttpPost(url);
            post.setHeader("Content-Type","text/xml;charset=utf-8");
            post.setHeader("SOAPAction",soapAction);
            //使用base64进行加密 并转换为string
            String tokenStr = new String(Base64.encodeBase64(("szy-2008:abc@1234").getBytes()));
            //token的格式:Basic YFUDIBGDJHFK78HFJDHF==
            String token = "Basic "+tokenStr;
            post.setHeader("Authorization",token);

            entity=new StringEntity(req);
            post.setEntity(entity);
            HttpResponse response=client.execute(post);
            if (response!=null && response.getStatusLine().getStatusCode()==200){
                return EntityUtils.toString(response.getEntity());
            }else {
                System.out.println(response.getStatusLine().getStatusCode());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (null!=entity)entity.consumeContent();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String parseResult(String xml){
        String res="";
        try {
            Integer a=xml.indexOf("<JTHC_DeptsResult>");
            Integer b=xml.indexOf("</JTHC_DeptsResult>");
            res=xml.substring(a+"<JTHC_DeptsResult>".length(),b);
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;

    }
}
