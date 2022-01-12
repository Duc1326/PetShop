package com.example.ducluu.petshop.model;

public class thucung {
    public String mathu;
    public String maloai;
    public String tenthu;
    public int gia;
    public int soluong;
    private int Hinh;


    public thucung(String mathu, String maloai, String tenthu, int gia, int soluong, int hinh) {
        this.mathu = mathu;
        this.maloai = maloai;
        this.tenthu = tenthu;
        this.gia = gia;
        this.soluong = soluong;
        Hinh = hinh;
    }

    public String getMathu() {
        return mathu;
    }

    public void setMathu(String mathu) {
        this.mathu = mathu;
    }

    public String getMaloai() {
        return maloai;
    }

    public void setMaloai(String maloai) {
        this.maloai = maloai;
    }

    public String getTenthu() {
        return tenthu;
    }

    public void setTenthu(String tenthu) {
        this.tenthu = tenthu;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}
