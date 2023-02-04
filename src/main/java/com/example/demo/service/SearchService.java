package com.example.demo.service;

import com.example.demo.domain.Ask;
import com.example.demo.dto.SearchRequestDto;
import com.example.demo.repository.AskRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SearchService {
    AskRepository askRepository;




    public List<Ask> search(SearchRequestDto dto) {

        List<Ask> ask = askRepository.findByTitleContaining(dto.getContents());
        return ask;
    }

}
