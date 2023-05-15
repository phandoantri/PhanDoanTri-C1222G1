package com.example.ss9_muon_sach.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book_manager")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int  quantity;
    @ManyToMany
    @JoinTable(
            name = "book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    List<Order> orderList;


    public Book() {
    }

    public Book(int id, String name, int quantity, List<Order> orderList) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.orderList = orderList;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
