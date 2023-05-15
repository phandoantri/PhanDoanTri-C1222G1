package com.example.ss9_muon_sach.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "phieu_muon")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int code;
    private Date date;



    public Order() {
    }

    public Order(int id, int code, Date date) {
        this.id = id;
        this.code = code;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
