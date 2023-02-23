package com.example.demo.repository;

import com.example.demo.domain.Member;
import com.example.demo.dto.MemberRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);

    Optional<Member> findByName(String name);

    Member save(Member member);


   // Optional<Member> findById(String id);

    Member findById(String id);

    List<Member> findAll();

     Optional<Member> findByNo(Long no);
     Member deleteByNo(Long no);
      // Member update(Member member);




}
