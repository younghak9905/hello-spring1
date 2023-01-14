package com.example.demo.controller;

import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.metamodel.SingularAttribute;
import java.time.LocalDateTime;
import java.util.Date;

import static org.springframework.data.jpa.domain.AbstractAuditable_.createdDate;

public class AskForm {

    private String title;
    private String contents;
    // private Long writerNo;
    private String tags;
    private LocalDateTime createdDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    /*public Long getWriterNo() {
        return writerNo;
    }

    public void setWriterNo(Long writerNo) {
        this.writerNo =writerNo;
    }*/

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public LocalDateTime getCreatedDate() {
        return LocalDateTime.now();
    }


}
