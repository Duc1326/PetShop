package com.example.ducluu.petshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class TroChuyen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tro_chuyen);
        BottomNavigationView bt  = findViewById(R.id.bottom_navigation);

        bt.setSelectedItemId(R.id.navigation_chat);

        bt.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.navigation_home:
                        Intent trangchu = new Intent(TroChuyen.this, TrangChu.class);
                        startActivity(trangchu);
                        break;
                    case R.id.navigation_cart:
                        Intent giohang = new Intent(TroChuyen.this,GioHang.class);
                        startActivity(giohang);
                        break;
                    case R.id.navigation_chat:

                        break;
                    case R.id.navigation_notifications:
                        Intent thongbao = new Intent(TroChuyen.this,ThongBao.class);
                        startActivity(thongbao);
                        break;
                    case R.id.navigation_person:
                        Intent canhan = new Intent(TroChuyen.this,NguoiDung.class);
                        startActivity(canhan);
                        break;

                }


                return true;
            }
        });
    }
}