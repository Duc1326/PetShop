package com.example.ducluu.petshop;

public class spSanPham {
    private String Ten;
    private String Gia;
    private String Mota;
    private String Xem;
    private int Hinh;

    public spSanPham(String ten, String gia, String mota, int hinh) {
        Ten = ten;
        Gia = gia;
        Mota = mota;
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

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}
