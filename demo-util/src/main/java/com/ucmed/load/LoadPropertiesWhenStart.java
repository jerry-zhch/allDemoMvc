package com.ucmed.load;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class LoadPropertiesWhenStart implements InitializingBean {
    private static final Logger log=Logger.getLogger("LoadPropertiesWhenStart");
    private static Map<String,String> map=new HashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("afterPropertiesSet=====>load===========");
        try {

        }catch (Exception e){
            log.info("afterPropertiesSet=====>error=====>"+e);
        }
    }
}
