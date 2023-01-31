package com.example.demo.service;

import com.example.demo.domain.Ask;
import com.example.demo.dto.AskRequestDto;
import com.example.demo.dto.AskResponseDto;
import com.example.demo.repository.AskRepository;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class AskService {

    private final AskRepository askRepository;

    public AskService(AskRepository askRepository) {
        this.askRepository = askRepository;
    }

    public Long write(AskRequestDto dto) {
        Ask ask = dto.toEntity();

        askRepository.save(ask);
        return ask.getNo();

    }


    public List<Ask> findAsks() {
        return askRepository.findAll();
    }

    public Optional<Ask> findOne(Long askNo) {
        return askRepository.findByNo(askNo);
    }


    public AskResponseDto findAsk(Long no) {
        Ask ask = askRepository.findByNo(no).get();
        return new AskResponseDto(ask);
    }

    public List<Ask> findByTitleContaining(String title) {
        if (title != null) {
            return askRepository.findByTitleContaining(title);
        }
        return null;
    }


    //-내가 손댄부분->

    public List<Ask> findAllByTags(String tag) {
    //태그 이름이 reversing인거에서 찾기
        if(tag!=null){
            return askRepository.findAllByTags(tag);
        }
        return null;
    }
}
