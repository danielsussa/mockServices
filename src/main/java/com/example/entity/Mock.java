package com.example.entity;

import javax.persistence.*;

/**
 * Created by DEK on 12/03/2017.
 */

@Entity
public class Mock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column( length = 100000 )
    private String request;

    @Lob
    @Column( length = 100000 )
    private String response;

    @ManyToOne
    private Module module;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
