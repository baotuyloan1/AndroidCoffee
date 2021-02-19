package com.example.appbanhang.Model;

import java.io.Serializable;

public class SanPham implements Serializable {
    private int id;
    private String name;
    private int producerId;
    private int productCateId;
    private double price;
    private int netWeight;
    private String roast;
    private String image;
    private String shelfLife;
    private String particleSize;
    private String taste;
    private int quantity;
    private String ingredient;
    private int sold;
    private int status;
    private double promotion;

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

    public int getProducerId() {
        return producerId;
    }

    public void setProducerId(int producerId) {
        this.producerId = producerId;
    }

    public int getProductCateId() {
        return productCateId;
    }

    public void setProductCateId(int productCateId) {
        this.productCateId = productCateId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(int netWeight) {
        this.netWeight = netWeight;
    }

    public String getRoast() {
        return roast;
    }

    public void setRoast(String roast) {
        this.roast = roast;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(String shelfLife) {
        this.shelfLife = shelfLife;
    }

    public String getParticleSize() {
        return particleSize;
    }

    public void setParticleSize(String particleSize) {
        this.particleSize = particleSize;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getPromotion() {
        return promotion;
    }

    public void setPromotion(double promotion) {
        this.promotion = promotion;
    }

    public SanPham(int id, String name, int producerId, int productCateId, double price, int netWeight, String roast, String image, String shelfLife, String particleSize, String taste, int quantity, String ingredient, int sold, int status, double promotion) {
        this.id = id;
        this.name = name;
        this.producerId = producerId;
        this.productCateId = productCateId;
        this.price = price;
        this.netWeight = netWeight;
        this.roast = roast;
        this.image = image;
        this.shelfLife = shelfLife;
        this.particleSize = particleSize;
        this.taste = taste;
        this.quantity = quantity;
        this.ingredient = ingredient;
        this.sold = sold;
        this.status = status;
        this.promotion = promotion;
    }
}
