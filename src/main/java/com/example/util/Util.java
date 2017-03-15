package com.example.util;

/**
 * Created by dekanczuk on 13/03/2017.
 */
public class Util {
    static public String regexAll(String str){
        str = str.replaceAll("\\s+","").replaceAll("<!--Optional:-->","");
        return str;
    }

    static public String deleteHeader(String str){
        String head = str.substring(0,str.indexOf(">")+1);
        String strSpl[] = str.split("Header");
        if(strSpl.length ==1 ){
            return str;
        }
        String body = strSpl.length == 3 ? strSpl[2] : strSpl[1];
        body = body.substring(body.indexOf("<"),body.length());
        return head+body;
    }

    static public String removeDust(String str){
        int init = str.contains("?>") ? str.indexOf("?>")+2 : 0;
        return str.substring(init,str.length());
    }
}
