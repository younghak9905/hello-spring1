package com.example.demo.service;

import com.example.demo.controller.AskForm;
import com.example.demo.domain.Ask;
import com.example.demo.dto.AskRequestDto;
import com.example.demo.dto.AskResponseDto;
import com.example.demo.repository.AskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
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



}
