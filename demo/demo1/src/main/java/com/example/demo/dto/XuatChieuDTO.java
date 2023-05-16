package com.example.demo.dto;

import com.example.demo.model.Phim;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class XuatChieuDTO {
    private int id;
    @NotNull
    @Pattern(regexp = "^CI-\\d{4}$")
    private String code;
    private Date ngayChieu;
    @Min(value = 1)
    private int soLuongVe;

    private Phim phim;

    public XuatChieuDTO() {
    }

    public XuatChieuDTO(int id, String code, Date ngayChieu, int soLuongVe, Phim phim) {
        this.id = id;
        this.code = code;
        this.ngayChieu = ngayChieu;
        this.soLuongVe = soLuongVe;
        this.phim = phim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(Date ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public int getSoLuongVe() {
        return soLuongVe;
    }

    public void setSoLuongVe(int soLuongVe) {
        this.soLuongVe = soLuongVe;
    }

    public Phim getPhim() {
        return phim;
    }

    public void setPhim(Phim phim) {
        this.phim = phim;
    }
}

