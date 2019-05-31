package com.juntaihc;

import com.juntaihc.jdk.MyAuthenticator;
import com.juntaihc.jdk.Service;
import com.juntaihc.jdk.ServiceSoap;
import com.juntaihc.www.ServiceStub;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import java.net.Authenticator;

public class ServiceTest {
    private static final Logger log=Logger.getLogger("ServiceTest");

    public static void main(String[] args) throws Exception{
        //1.jdk自带方式，未能成功
//        try {
//            Authenticator.setDefault(new MyAuthenticator());
//            Service service=new Service();
//            ServiceSoap serviceSoap=service.getServiceSoap();
//            String res=serviceSoap.jthcDepts("sN70eYSNMIUDfPRT1wzpO");
//            System.out.println(res);
//        }catch (Exception e){
//            log.info("error 11==>"+e);
//        }

        //2.axis2客户端，推荐
        try {
            ServiceStub stub=new ServiceStub();
            ServiceStub.JTHC_Depts depts=new ServiceStub.JTHC_Depts();
            depts.setAUTH_KEY("sN70eYSNMIUDfPRT1wzpO");
            ServiceStub.JTHC_DeptsResponse deptsResponse=stub.jTHC_Depts(depts);
            JSONObject result=JSONObject.fromObject(deptsResponse.getJTHC_DeptsResult());
            System.out.println(result);
        }catch (Exception e){
            log.info("error 22==>"+e);
        }

        //3.post请求
//        String req="<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:jun=\"http://www.juntaihc.com/\">" +
//                "   <soap:Header/>" +
//                "   <soap:Body>" +
//                "      <jun:JTHC_Depts>" +
//                "         <!--Optional:-->" +
//                "         <jun:AUTH_KEY>sN70eYSNMIUDfPRT1wzpO</jun:AUTH_KEY>" +
//                "      </jun:JTHC_Depts>" +
//                "   </soap:Body>" +
//                "</soap:Envelope>";
//        String s="http://www.juntaihc.com/JTHC_Depts";
//        String u="http://localhost:8060/Service.asmx";
//        System.out.println(JSONObject.fromObject(RequestForZyy.parseResult(RequestForZyy.requestWebservie(req,u,s))));

    }

}
