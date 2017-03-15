package com.example.controller;

import com.example.entity.Mock;
import com.example.util.TransformXML;
import com.example.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DEK on 11/03/2017.
 */

@Controller
@RequestMapping
public class MainController {

    private Map<String,Mock> mockMap = new HashMap<>();

    @ResponseBody
    @RequestMapping("/**")
    public String main(@RequestBody String xmlRequest){
        Map<String,String> requestMap = TransformXML.transformToMap(xmlRequest);
        String regexrequest = Util.deleteHeader(Util.regexAll(xmlRequest));
        Mock mock = mockMap.get(regexrequest);
        if(mock != null){
            return mock.getResponse();
        }
        return "Não existe response para o request:"+xmlRequest;
    }


    public void setRequestMap(Map<String, Mock> requestMap) {
        this.mockMap = requestMap;
    }
}
