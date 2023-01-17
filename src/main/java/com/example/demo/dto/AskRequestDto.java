package com.example.demo.dto;

import com.example.demo.domain.Ask;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AskRequestDto {
    private Long no;
    private String title;
    private String contents;
    private String createdDate;

    private String tags;
    public Ask toEntity() {
        Ask ask = Ask.builder()
                .no(no)
                .title(title)
                .contents(contents)
                .tags(tags)
                .build();
        return ask;
    }
}
