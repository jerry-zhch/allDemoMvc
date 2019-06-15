package com.ucmed.utils;

import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;

public class UrlUtil {

    /**
     * 中文编码转换
     */
    public static String getParams(String str){
        try {
            if(StringUtils.isEmpty(str)){
                str="";
            }else if(str.equals(new String(str.getBytes("ISO-8859-1"), "ISO-8859-1"))){
                str = new String(str.getBytes("ISO-8859-1"), "UTF-8");
            }else if(str.equals(new String(str.getBytes("gbk"), "gbk"))){
                str = new String(str.getBytes("gbk"), "UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }
}
