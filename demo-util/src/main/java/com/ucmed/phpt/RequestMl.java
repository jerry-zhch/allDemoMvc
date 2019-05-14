package com.ucmed.phpt;

import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

public class RequestMl {
    private static final Logger logger=Logger.getLogger("RequestMl");
    private String mlUrl;
    //    private String appKey;
    private String notifyUrl;
    private String returnUrl;
    private String ml3DESKey;
    private String appId;

    public void setMl3DESKey(String ml3DESKey) {
        this.ml3DESKey = ml3DESKey;
    }
    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
    public void setMlUrl(String mlUrl) {
        this.mlUrl = mlUrl;
    }
    //    public void setAppKey(String appKey) {
//        this.appKey = appKey;
//    }
    public void setAppId(String appId){
        this.appId=appId;
    }

    /**
     * 请求默联支付接口
     */
    public JSONObject requestActionParams(JSONObject req) {
        try {
            String reqString=req.toString();
            String result=request(reqString);
            if (null != result) {
                JSONObject res=JSONObject.fromObject(result);
                res.put("R",200);
                return res;
            }
        }catch (Exception e){
            logger.info("requestML==>requestActionParams==>error==>"+e);
        }
        JSONObject res = new JSONObject();
        res.put("R", -1);
        res.put("I", "支付接口异常");
        return res;
    }

    /**
     * 签名
     */
    static String sign(TreeMap<String, Object> params) throws Exception {
        // 签名明文组装不包含sign字段
        if (params.containsKey("sign")) {
            params.remove("sign");
        }
        //加密时需要添加key，如果没有的话此处添加一个
        if (!params.containsKey("key")) {
            params.put("key","123456");
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (entry.getValue() != null && String.valueOf(entry.getValue()).length() > 0) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        // 记得是md5编码的加签
        String sign = md5(sb.toString().getBytes("UTF-8"));
        params.remove("key");
        return sign;
    }

    static String md5(byte[] b) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(b);
            byte[] hash = md.digest();
            StringBuffer outStrBuf = new StringBuffer(32);
            for (int i = 0; i < hash.length; i++) {
                int v = hash[i] & 0xFF;
                if (v < 16) {
                    outStrBuf.append('0');
                }
                outStrBuf.append(Integer.toString(v, 16).toLowerCase());
            }
            return outStrBuf.toString();
        } catch (NoSuchAlgorithmException e) {
            logger.info("requestML==>md5==>error==>"+e);
            return new String(b);
        }
    }

    /**
     * 6.3微信公众号支付入参
     */
    public JSONObject packagingWX(TreeMap<String,Object> b) throws Exception{
//        b.put("key", appKey);
        b.put("appId",appId);
        b.put("notifyUrl",notifyUrl);
        if (!b.containsKey("returnUrl")){
            b.put("returnUrl",returnUrl+"/weixin/order.htm?action=orderList");
        }
        String sign=sign(b);
        b.put("sign",sign);
        JSONObject jb=JSONObject.fromObject(b);
        logger.info("requestML==>packagingWX==>"+jb);
        String busiData3DES=Des3Utils.encode3Des(ml3DESKey,jb.toString());
        JSONObject reqData=new JSONObject();
        reqData.put("busiCode","WX_JSAPI");
        reqData.put("busiData",busiData3DES);
        return reqData;
    }

    /**
     * 6.4 APP微信支付
     */
    public JSONObject packagingAPPwx(TreeMap<String,Object> b) throws Exception{
//        b.put("key", appKey);
        b.put("notifyUrl",notifyUrl);
        String sign=sign(b);
        b.put("sign",sign);
        JSONObject jb=JSONObject.fromObject(b);
        logger.info("requestML==>packagingAPPwx==>"+jb);
        String busiData3DES=Des3Utils.encode3Des(ml3DESKey,jb.toString());
        JSONObject reqData=new JSONObject();
        reqData.put("busiCode","WX_APP");
        reqData.put("busiData",busiData3DES);
        return reqData;
    }
    /**
     * 6.5 APP支付宝支付
     */
    public JSONObject packagingAPPali(TreeMap<String,Object> b) throws Exception{
//        b.put("key", appKey);
        b.put("notifyUrl",notifyUrl);
        String sign=sign(b);
        b.put("sign",sign);
        JSONObject jb=JSONObject.fromObject(b);
//        logger.info("3DES=="+jb);
//        String busiData3DES=Des3Utils.encode3Des(ml3DESKey,jb.toString());
        JSONObject reqData=new JSONObject();
        reqData.put("busiCode","ALIPAY_APP");
        reqData.put("busiData",b);
        return reqData;
    }
    /**
     * 6.11取消订单接口入参
     */
    public JSONObject packagingCancel(TreeMap<String,Object> b) throws Exception{
//        b.put("key", appKey);
        String sign=sign(b);
        b.put("sign",sign);
        JSONObject reqData=new JSONObject();
        reqData.put("busiCode","CANCEL_ORDER");
        reqData.put("busiData",b);
        return reqData;
    }

    public static void main(String[] args) throws Exception{
        TreeMap<String,Object> treeMap=new TreeMap<>();
        treeMap.put("orderNo","558642665919758336");
        treeMap.put("payUrl","https://wx.tenpay.com/cgi-bin/mmpayweb-bin/checkmweb?prepay_id=wx22131800414610580b0a80b41148054546&package=1925477851");
        System.out.println(sign(treeMap));

    }

    /**
     * 请求默联支付接口
     */
    public String request(String obj) {
        StringEntity re = null;
        try {
            HttpClient httpClient= HttpClientBuilder.create().build();

            HttpPost httpPost=new HttpPost(mlUrl);
            httpPost.setHeader("Content-Type","application/json;charset=UTF-8");
            re=new StringEntity(obj, Charset.forName("UTF-8"));
            re.setContentEncoding("UTF-8");
            httpPost.setEntity(re);
            HttpResponse response=httpClient.execute(httpPost);
            if (response!=null && response.getStatusLine().getStatusCode()==200) {
                return EntityUtils.toString(response.getEntity(),"UTF-8");
            }
        } catch (Exception e) {
            logger.info("requestML==>request==>error==>" + e);
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
