package com.example.demo.service;

import com.example.demo.domain.Ask;
import com.example.demo.domain.Member;
import com.example.demo.dto.AskResponseDto;
import com.example.demo.dto.MemberProfileRequestDto;
import com.example.demo.dto.MemberRequestDto;
import com.example.demo.dto.MemberResponseDto;
import com.example.demo.repository.MemberRepository;
import com.example.demo.security.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import javax.security.auth.login.LoginContext;
import java.io.Flushable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public void validateDuplicateMember(Member member) {
        /*memberRepository.findById(member.getId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });*/
    }
    public Long join(MemberRequestDto requestDto) {
       // validateDuplicateMember(requestDto.toEntity());

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


    public MemberResponseDto findMember(Long no) {
        Member member = memberRepository.findByNo(no).get();
        return new MemberResponseDto(member);
    }
   public Map<String,String> validateHandling(Errors errors){
        Map<String,String >validatorResult = new HashMap<>();
        for(FieldError error : errors.getFieldErrors()){
            String validKeyName = String.format("valid_%s",error.getField());
            validatorResult.put(validKeyName,error.getDefaultMessage());
        }
        return validatorResult;
   }






}
