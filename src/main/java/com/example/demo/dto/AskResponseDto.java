package com.example.demo.dto;

import com.example.demo.domain.Ask;
import com.example.demo.domain.Member;
import com.example.demo.repository.AskRepository;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;



@Getter
public class AskResponseDto {
    private Long no;
    private String title;
    private String contents;
    private String tags;
    private String  createdDate;
    private Member writer;
    private List<CommentResponseDto> comments;
//Entity->Dto
    public AskResponseDto(Ask entity) {
        this.no = entity.getNo();
        this.title = entity.getTitle();
        this.contents = entity.getContents();
        this.tags = entity.getTags();
        this.writer = entity.getMember();
        this.comments = entity.getComment().stream()
                .map(CommentResponseDto::new)
                .collect(Collectors.toList());
    }
}





