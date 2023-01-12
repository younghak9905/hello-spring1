package com.example.demo.service;

import com.example.demo.controller.AskForm;
import com.example.demo.domain.Ask;
import com.example.demo.repository.AskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class AskService {

    private final AskRepository askRepository;

public AskService(AskRepository askRepository) {
        this.askRepository = askRepository;
    }

    public void write(Ask ask) {

        askRepository.save(ask);

    }


    public List<Ask> findAsks() {
        return askRepository.findAll();
    }
    public Optional<Ask> findOne(Long askNo) {
        return askRepository.findByNo(askNo);
    }


}
