package com.example.ducluu.petshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class GioHang extends AppCompatActivity {
    Button btnmua;
    ListView lviewSanPham;
    ArrayList<spGioHang> arraySP;
    GioHangAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giohang);


        BottomNavigationView bt  = findViewById(R.id.bottom_navigation);

        bt.setSelectedItemId(R.id.navigation_cart);

        bt.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.navigation_home:
                        Intent trangchu = new Intent(GioHang.this, TrangChu.class);
                        startActivity(trangchu);
                        break;
                    case R.id.navigation_cart:

                        break;
                    case R.id.navigation_chat:
                        Intent trochuyen = new Intent(GioHang.this,TroChuyen.class);
                        startActivity(trochuyen);
                        break;
                    case R.id.navigation_notifications:
                        Intent thongbao = new Intent(GioHang.this,ThongBao.class);
                        startActivity(thongbao);
                        break;
                    case R.id.navigation_person:
                        Intent canhan = new Intent(GioHang.this,NguoiDung.class);
                        startActivity(canhan);
                        break;

                }


                return true;
            }
        });
        anhxa();
        adapter = new GioHangAdapter(this,R.layout.dong_giohang,arraySP);
        lviewSanPham.setAdapter(adapter);
        btnmua = findViewById(R.id.btthanhtoan);
        btnmua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GioHang.this, ThanhToan.class);
                startActivity(intent);
            }
        });
    }

    private void anhxa() {
        lviewSanPham = (ListView) findViewById(R.id.lvSanPham);
        arraySP = new ArrayList<>();

        arraySP.add(new spGioHang("Chó lông xù đáng yêu","đ1.900.000",R.drawable.cho1));
        arraySP.add(new spGioHang("Chó lông xù đáng yêu","đ1.900.000",R.drawable.cho1));
        arraySP.add(new spGioHang("Chó lông xù đáng yêu","đ1.900.000",R.drawable.cho1));
        arraySP.add(new spGioHang("Chó lông xù đáng yêu","đ1.900.000",R.drawable.cho1));


    }


}