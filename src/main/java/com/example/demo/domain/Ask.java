package com.example.demo.domain;

import com.example.demo.controller.AskForm;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Entity
public class Ask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String contents;
   // private Long writerNo;
    @Column(nullable = false)
    private String tags;
    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdDate;


    public Long getNo() {
        return no;
    }
    public void setNo(Long no) {
        this.no = no;
    }
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
  /*  public Long getWriterNo() {
        return writerNo;
    }
    public void setWriterNo(Long writerNo) {
        this.writerNo = writerNo;
    }*/
    public String getTags() {
        return tags;
    }
    public void setTags(String tags) {
        this.tags = tags;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }


    // private LocalDateTime createdDate;


}
