package com.example.demo.service;

import com.example.demo.domain.Ask;
import com.example.demo.domain.Member;
import com.example.demo.dto.AskResponseDto;
import com.example.demo.dto.MemberRequestDto;
import com.example.demo.dto.MemberResponseDto;
import com.example.demo.repository.MemberRepository;
import com.example.demo.security.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.login.LoginContext;
import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService implements UserDetailsService {
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


    public MemberResponseDto findMember(Long no) {
        Member member = memberRepository.findByNo(no).get();
        return new MemberResponseDto(member);
    }
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Can't find"+id));
        return new UserDetailsImpl(member);
    }
    public Member login(String id,String password)
    {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Can't find"+id));
        if(member.getPassword().equals(password))
        {
            return member;
        }
        else
        {
            return null;
        }
    }
}
