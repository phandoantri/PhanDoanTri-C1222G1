package com.example.ss10.dto;

public class ProductFromCartDTO {
    private int id;
    private String name;
    private int price;
    private String link;
    private int quantity;
    private int total;

    public ProductFromCartDTO() {
    }

    public ProductFromCartDTO(int id, String name, int price, String link, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.link = link;
        this.quantity = quantity;
    }

    public ProductFromCartDTO(int id, String name, int price, String link, int quantity, int total) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.link = link;
        this.quantity = quantity;
        this.total = total;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
