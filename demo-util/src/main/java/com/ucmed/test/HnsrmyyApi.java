package com.ucmed.test;

import com.ucmed.utils.HttpUtil;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HnsrmyyApi {
    private static final Logger logger = Logger.getLogger(HnsrmyyApi.class);
    private static final String APIURL = "http://hensrmyy.zwjk.com/api/exec/1.htm";

    public static JSONObject request(String apiName, String apiParams) {
        JSONObject req = new JSONObject();
        JSONObject res = new JSONObject();
        try {
            if (!StringUtils.isEmpty(apiParams)) {
                req = JSONObject.fromObject(apiParams);
            }
            req.put("TX", apiName);
            req.put("T", "0");
            req.put("D", "app");
            req.put("V", "1.0.0");
            Map header = new HashMap();
            header.put("K", "ZW5sNWVWOWhibVJ5YjJsaw==");
            Map query = new HashMap();
            query.put("requestData", req.toString());
            logger.info("reqString->" + req.toString());
            long sTime = new Date().getTime();
            String resString = HttpUtil.getInstance().HeaderQueryPOST(APIURL, header, query);
            long eTime = new Date().getTime();
            res = JSONObject.fromObject(resString);
            logger.info("resString->" + res.toString());
            logger.info("costTime->" + (eTime - sTime) + "ms");
        } catch (Exception e) {
            res.put("R", 500);
            res.put("I", "服务器发生未知错误");
            logger.error("接口异常", e);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(request("G002025", "{\"TX\":\"G002025\",\"D\":\"app\",\"rbas_sxw\":\"\",\"rbas_week\":\"\",\"depart_code\":\"\",\"page_no\":1,\"title_code\":\"\",\"T\":\"0\",\"V\":\"1.0.0\",\"parent_code\":\"001\",\"rbas_date\":\"\",\"doctor_name\":\"\",\"doctor_code\":\"\",\"page_size\":30}"));
    }
}
