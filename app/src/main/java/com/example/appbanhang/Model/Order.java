package com.example.appbanhang.Model;

public class Order {
    private int id;
    private int status;
    private double totalPrice;
    private String dateOrder;
    private String note;
    private int userId;
    private int accId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Order(int id, int status, Double totalPrice, String dateOrder, String note, int userId, int accId) {
        this.id = id;
        this.status = status;
        this.totalPrice = totalPrice;
        this.dateOrder = dateOrder;
        this.note = note;
        this.userId = userId;
        this.accId = accId;
    }
}
