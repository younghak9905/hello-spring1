package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.dto.MemberRequestDto;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Transactional
public class MemberService{
    private final MemberRepository memberRepository;





    public void validateDuplicateMember(Member member) {

       Member members= memberRepository.findById(member.getId());
        if (members != null) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }


    }
    public Long join(MemberRequestDto dto) {
        validateDuplicateMember(dto.toEntity());


        return memberRepository.save(dto.toEntity()).getNo();
    }


     //전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    //특정 회원 조회
    public Optional<Member> findOne(Long memberNo) {
        return memberRepository.findByNo(memberNo);
    }
}
