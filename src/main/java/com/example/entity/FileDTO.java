package com.example.entity;

/**
 * Created by dekanczuk on 13/03/2017.
 */
public class FileDTO{

    private String requestPath;
    private String responsePath;

    public String getRequestPath() {
        return requestPath;
    }

    public void setRequestPath(String requestPath) {
        this.requestPath = requestPath;
    }

    public String getResponsePath() {
        return responsePath;
    }

    public void setResponsePath(String responsePath) {
        this.responsePath = responsePath;
    }
}
