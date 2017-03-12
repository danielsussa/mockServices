package com.example.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by DEK on 12/03/2017.
 */

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String postPassword;

    private String deletePassword;

    @OneToMany
    private List<Module> modules;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public String getPostPassword() {
        return postPassword;
    }

    public void setPostPassword(String postPassword) {
        this.postPassword = postPassword;
    }

    public String getDeletePassword() {
        return deletePassword;
    }

    public void setDeletePassword(String deletePassword) {
        this.deletePassword = deletePassword;
    }
}
