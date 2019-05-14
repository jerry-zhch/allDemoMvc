package com.ucmed.activemq;

import com.ucmed.model.AccessToken;
import com.ucmed.model.WeChatTemplate;
import com.ucmed.service.WeChatTemplateService;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class WxTemplateConsumer implements MessageListener{
    private static final Logger log=Logger.getLogger("WxTemplateConsumer");
    private static final String appId="wxb511c37b3eaa8301";
    private static final String appsecret="6c3a8cff5685790137d087ac0a2326fe";
    @Autowired
    private WeChatTemplateService weChatTemplateService;

    @Override
    public void onMessage(Message message) {
        try {
            log.info("onMessage=======>"+message);
            String t=((TextMessage) message).getText();
            log.info("onMessage===>t===>"+t);
//            JSONObject req=JSONObject.fromObject(t);
            JSONObject r=JSONObject.fromObject("{\"touser\":\"oMFkZ0h5Oz1Nmyk93i_2XScSpACM\",\"template_id\":\"O5Lw8PUc9yrkPKlH0C0hgHQgJdvEIFKH3jOcI-VpX3M\",\"url\":\"http://www.baidu.com\",\"data\":{\"first\":{\"value\":\"恭喜你购买成功！\",\"color\":\"#FF0000\"},\"keyword1\":{\"value\":\"巧克力\",\"color\":\"#173177\"},\"keyword2\":{\"value\":\"39.8元\",\"color\":\"#173177\"},\"keyword3\":{\"value\":\"2014年9月22日\",\"color\":\"#173177\"},\"remark\":{\"value\":\"欢迎再次购买！\",\"color\":\"#173177\"}}}");
            AccessToken accessToken=weChatTemplateService.getAccessToken(appId,appsecret);
            weChatTemplateService.sendTemplateMsg(accessToken.getAccess_token(),r.toString());
        }catch (Exception e){
            log.info("onMessage===>error===>"+e);
        }
    }

}
