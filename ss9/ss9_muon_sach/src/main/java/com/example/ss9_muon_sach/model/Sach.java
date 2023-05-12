package com.example.ss9_muon_sach.model;

public class Sach {
    private int id;
    private String tenSach;
    private int  soLuong;
    private int maSachMuon;

    public Sach() {
    }

    public Sach(int id, String tenSach, int soLuong, int maSachMuon) {
        this.id = id;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.maSachMuon = maSachMuon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getMaSachMuon() {
        return maSachMuon;
    }

    public void setMaSachMuon(int maSachMuon) {
        this.maSachMuon = maSachMuon;
    }
}
