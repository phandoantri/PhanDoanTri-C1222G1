package com.example.demo.dto;

import com.example.demo.model.XuatChieu;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

public class PhimDTO {
    private int id;


    private String tenPhim;



    public PhimDTO() {
    }

    public PhimDTO(int id, String tenPhim) {
        this.id = id;
        this.tenPhim = tenPhim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }
}
