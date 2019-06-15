package com.ucmed.nuts;

import net.sf.json.JSONObject;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class NutsXmlToJson {

    public static void main(String[] args) {
        String result = xml2JSON("<R><ReturnCode>0</ReturnCode>\r\n" +
                "	<ReturnInfo>成功</ReturnInfo>\r\n" +
                "	<list>\r\n" +
                "		<clinicName>CCU一病区</clinicName>\r\n" +
                "		<patientId>0000034992</patientId>\r\n" +
                "		<clinicType></clinicType>\r\n" +
                "		<inPatientId>0000034992-1</inPatientId>\r\n" +
                "		<patientName>张金良</patientName>\r\n" +
                "		<SickRoomId></SickRoomId>\r\n" +
                "		<SickRoom></SickRoom>\r\n" +
                "		<inHospitalNum>1</inHospitalNum>\r\n" +
                "		<bedNo></bedNo>\r\n" +
                "		<inpatientArea>10107103</inpatientArea>\r\n" +
                "		<enumSign>2</enumSign>\r\n" +
                "		<inHospitalDT>2018-08-29 15:25:22</inHospitalDT>\r\n" +
                "		<outHospitalDT>2018-09-05 15:34:32</outHospitalDT>\r\n" +
                "		<depositAmout>0</depositAmout>\r\n" +
                "		<totalAmout>0</totalAmout>\r\n" +
                "	</list></R>");
        result = result.replace("[\"", "\"");
        result = result.replace("\"]", "\"");
        result = result.replace("[{}]", "\"\"");
        System.out.println(result);
    }

    public static String xml2JSON(String xml) {
        JSONObject obj = new JSONObject();
        try {
            InputStream is = new ByteArrayInputStream(xml.getBytes("utf-8"));
            SAXBuilder sb = new SAXBuilder();
            Document doc = sb.build(is);
            Element root = doc.getRootElement();
            obj.put(root.getName(), iterateElement(root));
            return obj.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Map iterateElement(Element element) throws IOException {
        IsBase64Code isbase64 = new IsBase64Code();
        List jiedian = element.getChildren();
        Element et = null;
        Map obj = new HashMap();
        List list = null;
        for (int i = 0; i < jiedian.size(); i++) {
            list = new LinkedList();
            et = (Element) jiedian.get(i);
            if (et.getTextTrim().equals("")) {
                if (obj.containsKey(et.getName())) {
                    list = (List) obj.get(et.getName());
                }
                list.add(iterateElement(et));
                obj.put(et.getName(), list);
            } else {
                if (obj.containsKey(et.getName())) {
                    list = (List) obj.get(et.getName());
                }

                list.add(et.getTextTrim());
                obj.put(et.getName(), list);

                listPut(element,obj);
                listPut(et,obj);
            }
        }
        return obj;
    }

    private static void listPut(Element et,Map obj){
        if(!et.getAttributes().isEmpty()){
            List<String> list1 =new ArrayList<>();
            List lists = et.getAttributes();
            String s = lists.toString().replace("Attribute: ","");
            s = s.replace("[[", "");
            s = s.replace("]]", "");
            String[] a = s.split("=");
            a[1] = a[1].replace("\"", "");
            list1.add(a[1]);
            obj.put(a[0],list1);
        }
    }
}
