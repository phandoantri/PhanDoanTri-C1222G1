package com.example.ss8_task2.model;

import javax.persistence.*;

@Entity
@Table(name = "bai_hat")
public class BaiHat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tenBaiHat;
    private String ngheSi;
    private String theLoai;

    public BaiHat() {
    }

    public BaiHat(int id, String tenBaiHat, String ngheSi, String theLoai) {
        this.id = id;
        this.tenBaiHat = tenBaiHat;
        this.ngheSi = ngheSi;
        this.theLoai = theLoai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
