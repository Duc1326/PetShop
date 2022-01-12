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

public class ThuocThuY extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thuoc_thu_y);
        BottomNavigationView bt  = findViewById(R.id.bottom_navigation);

        bt.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.navigation_home:
                        Intent trangchu = new Intent(ThuocThuY.this, TrangChu.class);
                        startActivity(trangchu);
                        break;
                    case R.id.navigation_cart:
                        Intent giohang = new Intent(ThuocThuY.this,GioHang.class);
                        startActivity(giohang);
                        break;
                    case R.id.navigation_chat:
                        Intent trochuyen = new Intent(ThuocThuY.this,TroChuyen.class);
                        startActivity(trochuyen);
                        break;
                    case R.id.navigation_notifications:
                        Intent thongbao = new Intent(ThuocThuY.this,ThongBao.class);
                        startActivity(thongbao);
                        break;
                    case R.id.navigation_person:
                        Intent canhan = new Intent(ThuocThuY.this,NguoiDung.class);
                        startActivity(canhan);
                        break;

                }


                return true;
            }
        });
        button = (Button) findViewById(R.id.btn);
        anhxathuoccho();
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
                    anhxathuoccho();
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
                    anhxathuocmeo();
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
                    anhxathuocchim();
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
                    anhxathuocca();
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
    private void anhxathuocca() {
        lviewSanPham = (ListView) findViewById(R.id.lvSanPham);
        arraySP = new ArrayList<>();
        arraySP.add(new spSanPham("Thuốc trị Nấm da", "đ1.500.000", "trị tất cả nấm da cho cá cảnh", R.drawable.thuocca1));
        arraySP.add(new spSanPham("Thuốc trị Nấm da", "đ1.500.000", "trị tất cả nấm da cho cá cảnh", R.drawable.thuocca1));
        arraySP.add(new spSanPham("Thuốc trị Nấm da", "đ1.500.000", "trị tất cả nấm da cho cá cảnh", R.drawable.thuocca1));
        arraySP.add(new spSanPham("Thuốc trị Nấm da", "đ1.500.000", "trị tất cả nấm da cho cá cảnh", R.drawable.thuocca1));
        arraySP.add(new spSanPham("Thuốc trị Nấm da", "đ1.500.000", "trị tất cả nấm da cho cá cảnh", R.drawable.thuocca1));
        arraySP.add(new spSanPham("Thuốc trị Nấm da", "đ1.500.000", "trị tất cả nấm da cho cá cảnh", R.drawable.thuocca1));
        arraySP.add(new spSanPham("Thuốc trị Nấm da", "đ1.500.000", "trị tất cả nấm da cho cá cảnh", R.drawable.thuocca1));
        arraySP.add(new spSanPham("Thuốc trị Nấm da", "đ1.500.000", "trị tất cả nấm da cho cá cảnh", R.drawable.thuocca1));
    }
    private void anhxathuocchim() {
        lviewSanPham = (ListView) findViewById(R.id.lvSanPham);
        arraySP = new ArrayList<>();
        arraySP.add(new spSanPham("Thuốc trị tiêu chay","đ1.500.000","trị tiêu chảy, khản giọng, sã cánh",R.drawable.thuocchim));
        arraySP.add(new spSanPham("Thuốc trị tiêu chay","đ1.500.000","trị tiêu chảy, khản giọng, sã cánh",R.drawable.thuocchim));
        arraySP.add(new spSanPham("Thuốc trị tiêu chay","đ1.500.000","trị tiêu chảy, khản giọng, sã cánh",R.drawable.thuocchim));
        arraySP.add(new spSanPham("Thuốc trị tiêu chay","đ1.500.000","trị tiêu chảy, khản giọng, sã cánh",R.drawable.thuocchim));
        arraySP.add(new spSanPham("Thuốc trị tiêu chay","đ1.500.000","trị tiêu chảy, khản giọng, sã cánh",R.drawable.thuocchim));
        arraySP.add(new spSanPham("Thuốc trị tiêu chay","đ1.500.000","trị tiêu chảy, khản giọng, sã cánh",R.drawable.thuocchim));
        arraySP.add(new spSanPham("Thuốc trị tiêu chay","đ1.500.000","trị tiêu chảy, khản giọng, sã cánh",R.drawable.thuocchim));
        arraySP.add(new spSanPham("Thuốc trị tiêu chay","đ1.500.000","trị tiêu chảy, khản giọng, sã cánh",R.drawable.thuocchim));
        arraySP.add(new spSanPham("Thuốc trị tiêu chay","đ1.500.000","trị tiêu chảy, khản giọng, sã cánh",R.drawable.thuocchim));
    }
    private void anhxathuoccho() {
        lviewSanPham = (ListView) findViewById(R.id.lvSanPham);
        arraySP = new ArrayList<>();
        arraySP.add(new spSanPham("Thuốc trị bọ chét","1.500.000","Trị tất cả các loại bọ chét",R.drawable.thuoccho));
        arraySP.add(new spSanPham("Thuốc trị bọ chét","1.500.000","Trị tất cả các loại bọ chét",R.drawable.thuoccho));
        arraySP.add(new spSanPham("Thuốc trị bọ chét","1.500.000","Trị tất cả các loại bọ chét",R.drawable.thuoccho));
        arraySP.add(new spSanPham("Thuốc trị bọ chét","1.500.000","Trị tất cả các loại bọ chét",R.drawable.thuoccho));
        arraySP.add(new spSanPham("Thuốc trị bọ chét","1.500.000","Trị tất cả các loại bọ chét",R.drawable.thuoccho));
        arraySP.add(new spSanPham("Thuốc trị bọ chét","1.500.000","Trị tất cả các loại bọ chét",R.drawable.thuoccho));
        arraySP.add(new spSanPham("Thuốc trị bọ chét","1.500.000","Trị tất cả các loại bọ chét",R.drawable.thuoccho));
        arraySP.add(new spSanPham("Thuốc trị bọ chét","1.500.000","Trị tất cả các loại bọ chét",R.drawable.thuoccho));
        arraySP.add(new spSanPham("Thuốc trị bọ chét","1.500.000","Trị tất cả các loại bọ chét",R.drawable.thuoccho));

    }
    private void anhxathuocmeo() {
        lviewSanPham = (ListView) findViewById(R.id.lvSanPham);
        arraySP = new ArrayList<>();
        arraySP.add(new spSanPham("Thuốc tẩy giun cho mèo","1.500.000","Trị tất cả các loại giun sán",R.drawable.thuocmeo));
        arraySP.add(new spSanPham("Thuốc tẩy giun cho mèo","1.500.000","Trị tất cả các loại giun sán",R.drawable.thuocmeo));
        arraySP.add(new spSanPham("Thuốc tẩy giun cho mèo","1.500.000","Trị tất cả các loại giun sán",R.drawable.thuocmeo));
        arraySP.add(new spSanPham("Thuốc tẩy giun cho mèo","1.500.000","Trị tất cả các loại giun sán",R.drawable.thuocmeo));
        arraySP.add(new spSanPham("Thuốc tẩy giun cho mèo","1.500.000","Trị tất cả các loại giun sán",R.drawable.thuocmeo));
        arraySP.add(new spSanPham("Thuốc tẩy giun cho mèo","1.500.000","Trị tất cả các loại giun sán",R.drawable.thuocmeo));
        arraySP.add(new spSanPham("Thuốc tẩy giun cho mèo","1.500.000","Trị tất cả các loại giun sán",R.drawable.thuocmeo));
        arraySP.add(new spSanPham("Thuốc tẩy giun cho mèo","1.500.000","Trị tất cả các loại giun sán",R.drawable.thuocmeo));
        arraySP.add(new spSanPham("Thuốc tẩy giun cho mèo","1.500.000","Trị tất cả các loại giun sán",R.drawable.thuocmeo));
        arraySP.add(new spSanPham("Thuốc tẩy giun cho mèo","1.500.000","Trị tất cả các loại giun sán",R.drawable.thuocmeo));

    }
}