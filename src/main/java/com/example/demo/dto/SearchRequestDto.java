package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchRequestDto {
    private String contents;

    public SearchRequestDto(String contents) {
        this.contents = contents;
    }


}
