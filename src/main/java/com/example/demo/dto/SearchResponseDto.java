package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchResponseDto {
    private String contents;

    public SearchResponseDto(String contents) {
        this.contents = contents;
    }
}
