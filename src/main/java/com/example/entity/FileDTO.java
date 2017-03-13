package com.example.entity;

/**
 * Created by dekanczuk on 13/03/2017.
 */
public class FileDTO{

    private String name;
    private String requestPath;
    private String responsePath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
