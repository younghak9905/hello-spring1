package com.example.demo.controller;

import com.example.demo.domain.CustomValidationException;
import com.example.demo.domain.Member;
import com.example.demo.dto.ImageRequestDto;
import com.example.demo.service.ImageService;
import com.example.demo.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class ImageController {

    private final ImageService imageService;
    private final LoginService loginService;



    @PostMapping(value="/image")
    public String imageUpload(ImageRequestDto imageUploadDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Member LoginMember = loginService.getUserById(authentication.getName());
        if(imageUploadDto.getFile().isEmpty()){
            throw new CustomValidationException("이미지가 첨부되지 않았습니다.", null);
        }
        if(LoginMember.getImage()!=null){
            //기존 이미지를 삭제
            imageService.deleteImage(LoginMember.getImage().get(0).getImageNo());
        }

        imageService.upload(imageUploadDto, LoginMember);

        return "redirect:/members/memberPage/"+LoginMember.getNo();
    }


}

