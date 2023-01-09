package com.example.demo;

import com.example.demo.domain.Ask;
import com.example.demo.repository.AskRepository;
import com.example.demo.service.AskService;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
public class AskServiceIntergrationTest {
    @Autowired
    AskService askService;
    @Autowired
    AskRepository askRepository;
@Test//질문 글 작성
void 질문글작성() {
//given
    Ask ask = new Ask();
    ask.setContents("리버싱을 알려주세요");
    ask.setTitle("질문글");
    //ask.setWriterNo(1L);
    ask.setTags("Reversing");
    LocalDateTime dateTime = LocalDateTime.now();
    ask.setCreatedDate(dateTime);
    askRepository.save(ask);


//when
    List<Ask> askList = askRepository.findAll();
//then
    assertThat(askList.get(0).getContents()).isEqualTo("리버싱을 알려주세요");
    assertThat(askList.get(0).getTitle()).isEqualTo("질문글");
    //assertThat(askList.get(0).getWriterNo()).isEqualTo(1L);
    assertThat(askList.get(0).getTags()).isEqualTo("Reversing");
    assertThat(askList.get(0).getCreatedDate()).isEqualTo(dateTime);


}

//when

//then

}
