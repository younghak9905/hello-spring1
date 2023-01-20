package com.example.demo.dto;

import com.example.demo.domain.Ask;
import com.example.demo.domain.Comment;
import lombok.Getter;
import net.bytebuddy.asm.Advice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class CommentResponseDto {
    private Long commentNo;
    private String reply;
    private Ask askNo;
    private String replyDate=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    public CommentResponseDto(Comment comment) {

        this.reply = comment.getReply();
        this.replyDate = comment.getReplyDate();
        this.askNo = comment.getAsk();

    }
}
