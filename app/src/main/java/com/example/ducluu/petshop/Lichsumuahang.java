package com.example.ducluu.petshop;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Lichsumuahang extends AppCompatActivity {
    ListView lviewThongBao;
    ArrayList<spSanPham> arrayTB;
    SanPhamAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activi_lichsumuahang);
        anhxa();
        adapter = new SanPhamAdapter(this, R.layout.dong_lichsumuahang, arrayTB);
        lviewThongBao.setAdapter(adapter);
    }
    private void anhxa(){
        lviewThongBao =(ListView) findViewById(R.id.lvlisumuahang);
        arrayTB = new ArrayList<>();
        arrayTB.add(new spSanPham("Lồng chim","đ3.400.000","lồng chim cho chim từ 300g", R.drawable.cho1));
        arrayTB.add(new spSanPham("vòng cỗ chó","đ3.400.000","Vòng cỗ cho chó", R.drawable.cho1));
        arrayTB.add(new spSanPham("Hồ cá","đ3.400.000","hồ cá bằng kính chưa đc 10 lít nước", R.drawable.cho1));
    }
}
