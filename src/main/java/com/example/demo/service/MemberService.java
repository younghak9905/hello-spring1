package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.dto.MemberRequestDto;
import com.example.demo.repository.MemberRepository;
import org.springframework.stereotype.Service;import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

  /*  public Long join(Member member) {
        //같은 id 있는 중복 회원 X
        validateDuplicateMember(member);

        // Save the member
        memberRepository.save(member);

        return member.getNo();
    }*/

    public void validateDuplicateMember(Member member) {
        memberRepository.findById(member.getId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    public Long join(MemberRequestDto requestDto) {
        validateDuplicateMember(requestDto.toEntity());
        return memberRepository.save(requestDto.toEntity()).getNo();
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
