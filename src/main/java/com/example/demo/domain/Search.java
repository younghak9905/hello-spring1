package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Search {
    private String contents;

    public Search(String contents) {
        this.contents = contents;
    }
}
