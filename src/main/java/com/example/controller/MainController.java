package com.example.controller;

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

    private Map<String,String> requestMap = new HashMap<>();

    @ResponseBody
    @RequestMapping("/**")
    public String main(@RequestBody String xmlRequest){
        xmlRequest = Util.regexAll(xmlRequest);
        String xmlResponse = requestMap.get(xmlRequest);
        return xmlResponse;
    }

    public Map<String, String> getRequestMap() {
        return requestMap;
    }

    public void setRequestMap(Map<String, String> requestMap) {
        this.requestMap = requestMap;
    }
}
