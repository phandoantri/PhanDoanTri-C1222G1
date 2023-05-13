package com.example.ss9_muon_sach.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CheckSoLuong {
    @AfterThrowing(value = "execution(* com.example.ss9_muon_sach.controller.SachController.muonSach(..))")
    public void checkSoLuong(){
        System.out.println("da xay ra loi");
    }


}
