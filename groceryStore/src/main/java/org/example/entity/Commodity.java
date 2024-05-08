package org.example.entity;

//商品
public class Commodity {


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private  String id;
    //商品名
    private  String name;

    //商品单价
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
