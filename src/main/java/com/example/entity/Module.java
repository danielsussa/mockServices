package com.example.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by DEK on 12/03/2017.
 */

@Entity
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String postPassword;
    private String deletePassword;

    @ManyToOne
    private Project project;

    @OneToMany
    private List<Mock> mockModels;

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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Mock> getMockModels() {
        return mockModels;
    }

    public void setMockModels(List<Mock> mockModels) {
        this.mockModels = mockModels;
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
