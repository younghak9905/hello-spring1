package com.example.demo;

import com.example.demo.domain.Comment;
import com.example.demo.repository.AskRepository;
import com.example.demo.repository.CommentRepository;
import com.example.demo.service.AskService;
import com.example.demo.service.CommentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
@DisplayName("댓글 서비스 테스트")
public class CommentServiceIntergrationTest {
    @Autowired
    CommentService commentService;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    AskRepository askRepository;
    @Autowired
    AskService askService;

    @Test
    void 댓글작성() {
        //given
        Comment comment = new Comment();
        comment.setReply("댓글입니다");


        commentRepository.save(comment);
        //when
        List<Comment> commentList = commentRepository.findAll();
        //then
        assertThat(commentList.get(0).getReply()).isEqualTo("댓글입니다");


    }


}
