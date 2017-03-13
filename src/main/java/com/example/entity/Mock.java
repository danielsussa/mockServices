package com.example.entity;

import javax.persistence.*;

/**
 * Created by DEK on 12/03/2017.
 */


public class Mock {

    private String request;
    private String response;


    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}
