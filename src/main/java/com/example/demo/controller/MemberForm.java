package com.example.demo.controller;

import org.springframework.stereotype.Controller;


public class MemberForm {
    private String name;
    private String email;
    private String password;
    private String passwordConfirm;
    private String id;
    private String GitHub;
    private String Blog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }





    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGitHub() {
        return GitHub;
    }

    public void setGitHub(String gitHub) {
        GitHub = gitHub;
    }

    public String getBlog() {
        return Blog;
    }

    public void setBlog(String blog) {
        Blog = blog;
    }


}
