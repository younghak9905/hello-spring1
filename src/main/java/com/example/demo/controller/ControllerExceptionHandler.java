package com.example.demo.controller;

import com.example.demo.domain.CustomValidationException;
import com.example.demo.domain.Script;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


@RestController
    @ControllerAdvice //모든 Exception들을 낚아챔
    public class ControllerExceptionHandler {


        @ExceptionHandler(CustomValidationException.class) //CustomValidationException 발동하는 모든 Exception을 이 함수가 가로챔
        public String validationException(CustomValidationException e){
            if(e.getErrorMap() ==null){
                return Script.back(e.getMessage());
            }else{
                return Script.back(e.getErrorMap().toString());
            }
        }


    }

