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
    public Long save(CommentRequestDto dto,Long no) {

        Ask ask = askRepository.findByNo(no).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + no)
        );
        dto.setAsk(ask);
        Comment comment = dto.toEntity();
        commentRepository.save(comment);

        return dto.getCommentNo();
    }





    @Transactional
    public void delete(Long commentNo) {
        Comment comment = commentRepository.findByCommentNo(commentNo).orElseThrow(
                () -> new IllegalArgumentException("해당 댓글이 없습니다. no=" + commentNo)
        );
        commentRepository.delete(comment);
    }


    @Transactional
    public Long reply(CommentRequestDto dto,Long no) {
        Ask ask = askRepository.findByNo(no).orElseThrow(
                () -> new IllegalArgumentException("해당 게시물이 없습니다. id=" + no)
        );
        Comment comment = commentRepository.findByCommentNo(dto.getCommentGroup()).orElseThrow(
                () -> new IllegalArgumentException("해당 댓글이 없습니다. no=" + dto.getCommentGroup())
        );
        dto.setAsk(ask);

        dto.setDepth(comment.getDepth()+1);
        Comment replyComment = dto.toEntity();
        commentRepository.save(replyComment);
        return dto.getCommentNo();
    }

    @Transactional
    public void update(Long commentNo) {
        Comment comment = commentRepository.findByCommentNo(commentNo).orElseThrow(
                () -> new IllegalArgumentException("해당 댓글이 없습니다. no=" + commentNo)
        );
        comment.update(commentNo);
    }


}
