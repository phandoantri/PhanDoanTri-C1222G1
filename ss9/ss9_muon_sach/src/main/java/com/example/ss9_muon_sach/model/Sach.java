package com.example.ss9_muon_sach.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "quan_ly_sach")
public class Sach {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String tenSach;
    private int  soLuong;
    @ManyToMany
    @JoinTable(
            name = "sach_muon",
            joinColumns = @JoinColumn(name = "sach_id"),
            inverseJoinColumns = @JoinColumn(name = "phieu_muon_id"))
    List<PhieuMuon> phieuMuons;


    public Sach() {
    }

    public Sach(int id, String tenSach, int soLuong) {
        this.id = id;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<PhieuMuon> getPhieuMuons() {
        return phieuMuons;
    }

    public void setPhieuMuons(List<PhieuMuon> phieuMuons) {
        this.phieuMuons = phieuMuons;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }


}
