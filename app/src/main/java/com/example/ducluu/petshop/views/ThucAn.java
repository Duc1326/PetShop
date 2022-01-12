package com.example.ducluu.petshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class ThucAn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thuc_an);
        BottomNavigationView bt  = findViewById(R.id.bottom_navigation);

        bt.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.navigation_home:
                        Intent trangchu = new Intent(ThucAn.this, TrangChu.class);
                        startActivity(trangchu);
                        break;
                    case R.id.navigation_cart:
                        Intent giohang = new Intent(ThucAn.this,GioHang.class);
                        startActivity(giohang);
                        break;
                    case R.id.navigation_chat:
                        Intent trochuyen = new Intent(ThucAn.this,TroChuyen.class);
                        startActivity(trochuyen);
                        break;
                    case R.id.navigation_notifications:
                        Intent thongbao = new Intent(ThucAn.this,ThongBao.class);
                        startActivity(thongbao);
                        break;
                    case R.id.navigation_person:
                        Intent canhan = new Intent(ThucAn.this,NguoiDung.class);
                        startActivity(canhan);
                        break;

                }


                return true;
            }
        });

        button = (Button) findViewById(R.id.btn);
        anhxacho();
        adapter = new SanPhamAdapter(this,R.layout.dong_sanpham,arraySP);
        lviewSanPham.setAdapter(null);
        lviewSanPham.setAdapter(adapter);
        button.setBackground(Drawable.createFromPath("#FE9D9D"));
    }
    Button button;
    ListView lviewSanPham;
    ArrayList<spSanPham> arraySP;
    SanPhamAdapter adapter;

    public void onClick(View v) {

        Drawable dr = getResources().getDrawable(R.drawable.button_pressed);
        dr.setColorFilter(Color.parseColor("#FE9D9D"), PorterDuff.Mode.SRC_ATOP);

        switch (v.getId()) {
            case R.id.btn:

                if (button == null) {
                    button = (Button) findViewById(v.getId());

                } else {
                    button.setBackgroundResource(R.drawable.button_pressed);
                    button = (Button) findViewById(v.getId());
                    anhxacho();
                    adapter = new SanPhamAdapter(this,R.layout.dong_sanpham,arraySP);
                    lviewSanPham.setAdapter(null);
                    lviewSanPham.setAdapter(adapter);
                }
                button.setBackgroundDrawable(dr);

                break;

            case R.id.btn1:
                if (button == null) {
                    button = (Button) findViewById(v.getId());

                } else {
                    button.setBackgroundResource(R.drawable.button_pressed);
                    button = (Button) findViewById(v.getId());
                    anhxameo();
                    adapter = new SanPhamAdapter(this,R.layout.dong_sanpham,arraySP);
                    lviewSanPham.setAdapter(null);
                    lviewSanPham.setAdapter(adapter);
                }
                button.setBackgroundDrawable(dr);

                break;
            case R.id.btn2:
                if (button == null) {
                    button = (Button) findViewById(v.getId());
                } else {
                    button.setBackgroundResource(R.drawable.button_pressed);
                    button = (Button) findViewById(v.getId());
                    anhxachim();
                    adapter = new SanPhamAdapter(this,R.layout.dong_sanpham,arraySP);
                    lviewSanPham.setAdapter(null);
                    lviewSanPham.setAdapter(adapter);
                }
                button.setBackgroundDrawable(dr);

                break;
            case R.id.btn3:
                if (button == null) {
                    button = (Button) findViewById(v.getId());
                } else {
                    button.setBackgroundResource(R.drawable.button_pressed);
                    button = (Button) findViewById(v.getId());
                    anhxaca();
                    adapter = new SanPhamAdapter(this,R.layout.dong_sanpham,arraySP);
                    lviewSanPham.setAdapter(null);
                    lviewSanPham.setAdapter(adapter);
                }
                button.setBackgroundDrawable(dr);

                break;

            default:
                break;
        }
    }
    private void anhxaca(){
        lviewSanPham =(ListView) findViewById(R.id.lvSanPham);
        arraySP= new ArrayList<>();
        arraySP.add(new spSanPham("Thức ăn cho cá","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucanca));
        arraySP.add(new spSanPham("Thức ăn cho cá","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucanca));
        arraySP.add(new spSanPham("Thức ăn cho cá","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucanca));
        arraySP.add(new spSanPham("Thức ăn cho cá","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucanca));
        arraySP.add(new spSanPham("Thức ăn cho cá","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucanca));

    }
    private void anhxacho(){
        lviewSanPham =(ListView) findViewById(R.id.lvSanPham);
        arraySP= new ArrayList<>();
        arraySP.add(new spSanPham("Thức ăn cho chó","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucancho));
        arraySP.add(new spSanPham("Thức ăn cho chó","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucancho));
        arraySP.add(new spSanPham("Thức ăn cho chó","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucancho));
        arraySP.add(new spSanPham("Thức ăn cho chó","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucancho));
        arraySP.add(new spSanPham("Thức ăn cho chó","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucancho));

    }
    private void anhxachim(){
        lviewSanPham =(ListView) findViewById(R.id.lvSanPham);
        arraySP= new ArrayList<>();
        arraySP.add(new spSanPham("Thức ăn cho chim","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucanchim));
        arraySP.add(new spSanPham("Thức ăn cho chim","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucanchim));
        arraySP.add(new spSanPham("Thức ăn cho chim","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucanchim));
        arraySP.add(new spSanPham("Thức ăn cho chim","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucanchim));
        arraySP.add(new spSanPham("Thức ăn cho chim","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucanchim));

    }
    private void anhxameo(){
        lviewSanPham =(ListView) findViewById(R.id.lvSanPham);
        arraySP= new ArrayList<>();
        arraySP.add(new spSanPham("Thức ăn cho mèo","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucanmeo));
        arraySP.add(new spSanPham("Thức ăn cho mèo","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucanmeo));
        arraySP.add(new spSanPham("Thức ăn cho mèo","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucanmeo));
        arraySP.add(new spSanPham("Thức ăn cho mèo","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucanmeo));
        arraySP.add(new spSanPham("Thức ăn cho mèo","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucanmeo));

    }
}