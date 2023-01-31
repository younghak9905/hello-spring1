package com.example.demo.repository;

import com.example.demo.domain.Ask;
import com.example.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AskRepository extends JpaRepository<Ask, Long> {


    Ask save(Ask ask);

   Optional<Ask> findByNo(Long no);

    //titleContaining




    Optional<Ask> findByContents(String contents);

    List<Ask> findByTitleContaining(String title);

    List<Ask> findByContentsContaining(String contents);


 //  Optional<Ask> findByWriterNo(Long writerNo);

    Optional<Ask> findByTags(String tags);

   Optional<Ask> findByCreatedDate(String createdDate);

  List<Ask> findAll();
  List<Ask> findAllByTags(String Tags);


    //글쓰기


    void deleteByNo(Long no);


}
