package com.example.util;

/**
 * Created by dekanczuk on 13/03/2017.
 */
public class Util {
    static public String regexAll(String str){
        str = str.replaceAll("\\s+","").replaceAll("<!--Optional:-->","");
        String[] splitted = str.split("Body");
        String finalSpl = splitted[1];
        return finalSpl;
    }
}
