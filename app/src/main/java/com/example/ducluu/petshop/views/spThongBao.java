package com.example.ducluu.petshop;

public class spThongBao {
    private String mota;
    private int hinh;

    public spThongBao(String mota, int hinh) {
        this.mota = mota;
        this.hinh = hinh;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
