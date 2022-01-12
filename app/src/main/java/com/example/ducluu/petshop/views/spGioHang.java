package com.example.ducluu.petshop;

public class spGioHang {
    private String Ten;
    private String Gia;
    private int Hinh;

    public spGioHang(String ten, String gia, int hinh) {
        Ten = ten;
        Gia = gia;
        Hinh = hinh;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String gia) {
        Gia = gia;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}