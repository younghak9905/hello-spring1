package com.example.demo.dto;
import com.example.demo.domain.Ask;
import com.example.demo.domain.Member;
import lombok.*;
import com.example.demo.domain.Comment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CommentRequestDto {
    private Long commentNo;
    private String reply;
    private Ask ask;

    private Member writer;
    private String replyDate=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    private Long commentGroup=0L;
    private Long depth=0L;

    private String selected="false";
    public Comment toEntity() {
        Comment comments = Comment.builder()
                .commentNo(commentNo)
                .reply(reply)
                .replyDate(replyDate)
                .ask(ask)
                .member(writer)
                .commentGroup(commentGroup)
                .depth(depth)
                .selected(selected)
                .build();
        return comments;


    }



}
