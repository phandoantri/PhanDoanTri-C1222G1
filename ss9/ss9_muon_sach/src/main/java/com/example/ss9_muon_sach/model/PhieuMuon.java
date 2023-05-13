package com.example.ss9_muon_sach.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "phieu_muon")
public class PhieuMuon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idNguoiMuon;
    private String tenNguoiMuon;
    private int maMuon;
    private Date ngayMuon;



    public PhieuMuon() {
    }

    public PhieuMuon(int idNguoiMuon, String tenNguoiMuon, int maMuon, Date ngayMuon) {
        this.idNguoiMuon = idNguoiMuon;
        this.tenNguoiMuon = tenNguoiMuon;
        this.maMuon=maMuon;
        this.ngayMuon=ngayMuon;
    }

    public int getIdNguoiMuon() {
        return idNguoiMuon;
    }

    public void setIdNguoiMuon(int idNguoiMuon) {
        this.idNguoiMuon = idNguoiMuon;
    }

    public String getTenNguoiMuon() {
        return tenNguoiMuon;
    }

    public void setTenNguoiMuon(String tenNguoiMuon) {
        this.tenNguoiMuon = tenNguoiMuon;
    }

    public int getMaMuon() {
        return maMuon;
    }

    public void setMaMuon(int maMuon) {
        this.maMuon = maMuon;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }
}
