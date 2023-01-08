package com.example.demo.domain;

import com.example.demo.controller.AskForm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
@Entity
public class Ask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    private String title;
    private String contents;
   // private Long writerNo;
    private String tags;
   private LocalDateTime createdDate;
public void ask(String title, String contents, String tags) {
        this.title = title;
        this.contents = contents;
       // this.writerNo = writerNo;
        this.tags = tags;
        this.createdDate = LocalDateTime.now();
    }

    public void ask(AskForm askForm)
    {
        this.title = askForm.getTitle();
        this.contents = askForm.getContents();
       // this.writerNo = askForm.getWriterNo();
        this.tags = askForm.getTags();
        this.createdDate = LocalDateTime.now();
    }

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


}
