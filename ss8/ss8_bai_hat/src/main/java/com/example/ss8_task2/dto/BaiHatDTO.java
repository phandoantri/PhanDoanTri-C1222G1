package com.example.ss8_task2.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class BaiHatDTO {
    @NotBlank
    @Size(max = 800)
    @Pattern(regexp = "^((?=[A-Za-z0-9,])(?![_\\\\\\\\-]).)$",message = "Khong duoc chua cac ky tu dac biet")
    private String tenBaiHat;
    @NotBlank
    @Size(max = 800)
    @Pattern(regexp = "^((?=[A-Za-z0-9,])(?![_\\\\\\\\-]).)$",message = "Khong duoc chua cac ky tu dac biet")
    private String ngheSi;
    @NotBlank
    @Size(max = 1000)
    @Pattern(regexp = "^((?=[A-Za-z0-9,])(?![_\\\\\\\\-]).)$",message = "Khong duoc chua cac ky tu dac biet")
    private String theLoai;

    public BaiHatDTO() {
    }

    public BaiHatDTO(String tenBaiHat, String ngheSi, String theLoai) {
        this.tenBaiHat = tenBaiHat;
        this.ngheSi = ngheSi;
        this.theLoai = theLoai;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public String getNgheSi() {
        return ngheSi;
    }

    public void setNgheSi(String ngheSi) {
        this.ngheSi = ngheSi;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }
}
