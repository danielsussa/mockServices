package com.example.entity;

import com.example.util.Util;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by DEK on 12/03/2017.
 */


public class Mock {

    private String response;
    private Map<String,String> requestParams;
    private Map<String,String> responseParams;


    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Map<String, String> getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(Map<String, String> requestParams) {
        this.requestParams = requestParams;
    }

    public Map<String, String> getResponseParams() {
        return responseParams;
    }

    public void setResponseParams(Map<String, String> responseParams) {
        this.responseParams = responseParams;
    }
}
