package com.example.demo.service;

import com.example.demo.controller.AskForm;
import com.example.demo.domain.Ask;
import com.example.demo.repository.AskRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Transactional
public class AskService {
    private final AskRepository askRepository;

    public AskService(AskRepository askRepository) {
        this.askRepository = askRepository;
    }

    public void ask(AskForm askForm) {
        Ask ask = new Ask();
        ask.setTitle(askForm.getTitle());
        ask.setContents(askForm.getContents());
     //   ask.setWriterNo(askForm.getWriterNo());
        ask.setTags(askForm.getTags());
        askRepository.save(ask);
    }

    //글쓰기
    public void create(AskForm askForm) {
        Ask ask = new Ask();
        ask.ask(askForm);
        askRepository.save(ask);
    }

    //글 리스트


    //글열람
    public Optional<Ask> read(Long askNo) {
        return askRepository.findByNo(askNo);
    }


    //글수정
    public void update(AskForm askForm) {
        Ask ask = new Ask();
        ask.ask(askForm);
        askRepository.save(ask);
    }
    //글삭제
    public void delete(Long no) {

        askRepository.deleteByNo(no);
    }

    public List<Ask> findAsks() {
        return askRepository.findAll();
    }
}
