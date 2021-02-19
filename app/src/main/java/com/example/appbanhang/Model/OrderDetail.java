package com.example.appbanhang.Model;

public class OrderDetail {

    private int idOrder;
    private int idOrderDetail;
    private int priceSp;
    private int quantity;
    private SanPham sanPham;

    public OrderDetail(int idOrder, int idOrderDetail, int priceSp, int quantity, SanPham sanPham) {
        this.idOrder = idOrder;
        this.idOrderDetail = idOrderDetail;
        this.priceSp = priceSp;
        this.quantity = quantity;
        this.sanPham = sanPham;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdOrderDetail() {
        return idOrderDetail;
    }

    public void setIdOrderDetail(int idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
    }

    public int getPriceSp() {
        return priceSp;
    }

    public void setPriceSp(int priceSp) {
        this.priceSp = priceSp;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }
}
