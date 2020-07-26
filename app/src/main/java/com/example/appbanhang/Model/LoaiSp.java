package com.example.appbanhang.Model;

public class LoaiSp {
    public int id;
    public String tenLoaiSp;
    public String moTa;
    public int status;
    public String hinhLoaiSp;

    public LoaiSp() {
    }

    public LoaiSp(int id, String tenLoaiSp, String moTa, int status, String hinhLoaiSp) {
        this.id = id;
        this.tenLoaiSp = tenLoaiSp;
        this.moTa = moTa;
        this.status = status;
        this.hinhLoaiSp = hinhLoaiSp;
    }

    public String getHinhLoaiSp() {
        return hinhLoaiSp;
    }

    public void setHinhLoaiSp(String hinhLoaiSp) {
        this.hinhLoaiSp = hinhLoaiSp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLoaiSp() {
        return tenLoaiSp;
    }

    public void setTenLoaiSp(String tenLoaiSp) {
        this.tenLoaiSp = tenLoaiSp;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
