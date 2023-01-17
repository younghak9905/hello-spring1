package com.example.demo.dto;
import com.example.demo.domain.Ask;
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
    private String replyDate=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

    public Comment toEntity() {
        Comment comments = Comment.builder()
                .commentNo(commentNo)
                .reply(reply)
                .replyDate(replyDate)
                .ask(ask)
                .build();
        return comments;


    }
}
