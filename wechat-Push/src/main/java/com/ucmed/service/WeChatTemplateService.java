package com.ucmed.service;

import com.ucmed.model.AccessToken;
import com.ucmed.model.WeChatTemplate;
import com.ucmed.util.HttpReq;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

//微信模板消息
public class WeChatTemplateService {

    private static Logger logger = Logger.getLogger("WeChatTemplateService");

    /**
     * 获取access_token的接口地址
     */
    private final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    /**发送模板消息*/
    private static final String SEND_TEMPLATE_MESSAGE = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";

    /**
     * 通过APPID 和 APPSECRET
     * 获取assess_token
     */
    public AccessToken getAccessToken(String appid, String appsecret) {
        AccessToken accessToken = null;
        String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
        JSONObject jsonObject =JSONObject.fromObject(HttpReq.sendGet(requestUrl));
        // 如果请求成功
        if (null != jsonObject) {
            try {
                accessToken = new AccessToken();
                accessToken.setAccess_token(jsonObject.getString("access_token"));
                accessToken.setExpires_in(jsonObject.getInt("expires_in"));
            } catch (JSONException e) {
                accessToken = null;
                // 获取token失败
                logger.error("获取token失败 errcode:"+jsonObject.getInt("errcode")+" errmsg:"+jsonObject.getString("errmsg"));
            }
        }
        return accessToken;
    }

    /**
     * 发送模板消息
     */
    public void sendTemplateMsg(String accessToken, String data){
        String jsonString =data;
        String requestUrl =SEND_TEMPLATE_MESSAGE.replace("ACCESS_TOKEN",accessToken);
        JSONObject jsonObject=JSONObject.fromObject(HttpReq.sendPost(jsonString,requestUrl));
        logger.error("jsonObject值："+jsonObject);
        if (null != jsonObject) {
            int errorCode = jsonObject.getInt("errcode");
            if (0 == errorCode) {
                logger.info("模板消息发送成功");
            } else {
                String errorMsg = jsonObject.getString("errmsg");
                logger.info("模板消息发送失败,错误是 "+errorCode+",错误信息是"+ errorMsg);
            }
        }
    }

    public static void main(String[] args) {
        String s="{\"touser\":\"oMFkZ0h5Oz1Nmyk93i_2XScSpACM\",\"template_id\":\"O5Lw8PUc9yrkPKlH0C0hgHQgJdvEIFKH3jOcI-VpX3M\"," +
                "\"url\":\"http://weixin.qq.com/download\",\"miniprogram\":{\"appid\":\"xiaochengxuappid12345\",\"pagepath\":" +
                "\"index?foo=bar\"},\"data\":{\"first\":{\"value\":\"恭喜你购买成功！\",\"color\":\"#FF0000\"},\"keyword1\":" +
                "{\"value\":\"巧克力\",\"color\":\"#FF0000\"},\"remark\":{\"value\":\"欢迎再次购买！\",\"color\":\"#FF0000\"}}}";

        String appId="wxb511c37b3eaa8301";
        String appsecret="6c3a8cff5685790137d087ac0a2326fe";
        WeChatTemplateService weChatTemplateService=new WeChatTemplateService();
        AccessToken accessToken=weChatTemplateService.getAccessToken(appId,appsecret);
        weChatTemplateService.sendTemplateMsg(accessToken.getAccess_token(),s);
    }

}
