package com.example.demo.repository;

import com.example.demo.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Optional<Member> findByEmail(String email);

    Optional<Member> findByName(String name);

    Member save(Member member);


    Optional<Member> findById(String id);

    List<Member> findAll();

     Optional<Member> findByNo(Long no);
}
