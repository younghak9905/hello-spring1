package com.example.demo.dto;
import com.example.demo.domain.Ask;
import lombok.*;
import com.example.demo.domain.Comment;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CommentRequestDto {
    private Long commentNo;
    private String reply;
    private Ask askNo;
    private LocalDateTime replyDate = LocalDateTime.now();

    public Comment toEntity() {
        Comment comments = Comment.builder()
                .commentNo(commentNo)
                .reply(reply)
                .askNo(askNo)
                .replyDate(replyDate)
                .build();
        return comments;


    }
}
