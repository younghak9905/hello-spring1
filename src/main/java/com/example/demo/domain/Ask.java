package com.example.demo.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Ask {
    private Long no;
    private String title;
    private String contents;
    private String writer;
    private List<String> tags;
   private LocalDateTime createdDate;
public void ask(String title, String contents, String writer, List<String> tags) {
        this.title = title;
        this.contents = contents;
        this.writer = writer;
        this.tags = tags;
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
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    public List<String> getTags() {
        return tags;
    }
    public void setTags(List<String> tags) {
        this.tags = tags;
    }


}
