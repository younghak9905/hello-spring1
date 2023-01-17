package com.example.demo.dto;

import com.example.demo.domain.Ask;
import com.example.demo.domain.Comment;
import lombok.Getter;
import net.bytebuddy.asm.Advice;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private Long commentNo;
    private String reply;
    private Long askNo;
    private LocalDateTime replyDate = LocalDateTime.now();

    public CommentResponseDto(Comment comment) {
        this.commentNo = comment.getCommentNo;
        this.reply = comment.getReply();
        this.askNo = comment.getAskNo().getNo();
        this.replyDate = comment.getReplyDate;
    }
}
