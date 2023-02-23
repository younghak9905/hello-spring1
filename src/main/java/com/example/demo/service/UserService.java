package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.dto.MemberRequestDto;
import com.example.demo.dto.MemberResponseDto;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();



    public Member getUserByNo(Long no) {
Optional<Member> optionalMember = memberRepository.findByNo(no);
        return optionalMember.orElse(null);
    }

    public Member getUserById(String id) {
        return memberRepository.findById(id);
    }



    public void signup(MemberRequestDto userVo) { // 회원 가입
        if (!userVo.getName().equals("") && !userVo.getId().equals("")) {
            // password는 암호화해서 DB에 저장
            userVo.setPassword(passwordEncoder.encode(userVo.getPassword()));
            //MemberRequestDto to Member
          //dto to Member
            Member member = new Member(userVo);

            memberRepository.save(member);
        }
    }

  /*  public void edit(MemberRequestDto userVo) { // 회원 정보 수정
        // password는 암호화해서 DB에 저장
        userVo.setPassword(passwordEncoder.encode(userVo.getPassword()));
        Member member = new Member(userVo);
       memberRepository.update(member);
    }
*/
    public void withdraw(Long no) { // 회원 탈퇴
        memberRepository.deleteByNo(no);
    }

    public PasswordEncoder passwordEncoder() {
        return this.passwordEncoder;
    }
}