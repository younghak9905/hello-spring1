package com.example.demo.controller;

import com.example.demo.domain.Ask;
import com.example.demo.repository.AskRepository;
import com.example.demo.repository.CommentRepository;
import com.example.demo.service.AskService;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentForm {
    private Long commentNo;
    private Ask askNo;
    private String reply;
    private LocalDateTime replyDate;
    private AskRepository askRepository;

    public LocalDateTime getReplyDate() {
        return LocalDateTime.now();
    }
    public Ask getAskNo(Long askNo) {
        Ask ask = askRepository.findByNo(askNo).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id=" + askNo));
        return ask;
    }



}
