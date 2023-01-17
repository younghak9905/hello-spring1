package com.example.demo.service;

import com.example.demo.domain.Ask;
import com.example.demo.domain.Comment;
import com.example.demo.dto.CommentRequestDto;
import com.example.demo.repository.AskRepository;
import com.example.demo.repository.CommentRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final AskRepository askRepository;
    @Transactional
    public Long save(Comment comment,Long no) {
        Optional<Ask> findAsk = Optional.ofNullable(askRepository.findByNo(no).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id=" + no)));

        commentRepository.save(comment);
        return comment.getCommentNo();

    }


    public List<Comment> findComments() {
        return commentRepository.findAll();
    }
    public Optional<Comment> findBys(Long askNo) {
        return commentRepository.findByAskNo(askNo);
    }

    public List<Comment> findCommentsByAskNo(Long no) {
        return commentRepository.findAllByAskNo(no);
    }

    public Optional<Comment> findOne(Long commentNo) {
        return commentRepository.findByCommentNo(commentNo);
    }



}
