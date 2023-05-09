package com.example.ss4.model;

public class Product {
    private int id;
    private String name;
    private double cost;
    private String detail;

    public Product() {
    }

    public Product(int id, String name, double cost,String detail) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.detail=detail;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
