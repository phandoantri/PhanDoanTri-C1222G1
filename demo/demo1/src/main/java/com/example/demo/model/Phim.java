package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "phim")
public class Phim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "phim")
    private List<XuatChieu> xuatChieus;

    public Phim() {
    }

    public Phim(int id, String name, List<XuatChieu> xuatChieus) {
        this.id = id;
        this.name = name;
        this.xuatChieus = xuatChieus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<XuatChieu> getXuatChieus() {
        return xuatChieus;
    }

    public void setXuatChieus(List<XuatChieu> xuatChieus) {
        this.xuatChieus = xuatChieus;
    }
}
