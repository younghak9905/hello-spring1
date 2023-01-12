package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    private String name;
    private String email;
    private String password;

    private String id;

    private String github;

    private String blog;
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



    public String getGitHub() {
    	return github;
    }

    public void setGitHub(String github) {
    	this.github = github;
    }

    public String getBlog() {
    	return blog;
    }

    public void setBlog(String blog) {
    	this.blog = blog;
    }

    public String getId() {
    	return id;
    }

    public void setId(String id) {
    	this.id = id;
    }

    public Long getNo() {
    	return no;
    }

    public void setNo(Long no) {
    	this.no = no;
    }


}
