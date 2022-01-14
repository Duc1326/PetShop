package com.example.ducluu.petshop.model;

import java.io.Serializable;

public class thucung implements Serializable {
    public int id;
    public String maTL;
    public String tenthu;
    public String giong;
    public String gioiting;
    private String cannang;
    private String chieucao;
    private int tuoi;
    private int soluong;
    private String mota;
    private String hinhMon;
    private int giatien;

    private int numberInCard;

    public String getHinhMon() {
        return hinhMon;
    }

    public void setHinhMon(String hinhMon) {
        this.hinhMon = hinhMon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaTL() {
        return maTL;
    }

    public void setMaTL(String maTL) {
        this.maTL = maTL;
    }

    public String getTenthu() {
        return tenthu;
    }

    public void setTenthu(String tenthu) {
        this.tenthu = tenthu;
    }

    public String getGiong() {
        return giong;
    }

    public void setGiong(String giong) {
        this.giong = giong;
    }

    public String getGioiting() {
        return gioiting;
    }

    public void setGioiting(String gioiting) {
        this.gioiting = gioiting;
    }

    public String getCannang() {
        return cannang;
    }

    public void setCannang(String cannang) {
        this.cannang = cannang;
    }

    public String getChieucao() {
        return chieucao;
    }

    public void setChieucao(String chieucao) {
        this.chieucao = chieucao;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }


    public int getNumberInCard() {
        return numberInCard;
    }

    public void setNumberInCard(int numberInCard) {
        this.numberInCard = numberInCard;
    }

    public int getGiatien() {
        return giatien;
    }

    public void setGiatien(int giatien) {
        this.giatien = giatien;
    }
}
