package com.example.ducluu.petshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class ThongBao extends AppCompatActivity {
    ListView lviewThongBao;
    ArrayList<spThongBao> arraySP;
    ThongBaoApter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_bao);
        anhxa();
        adapter = new ThongBaoApter(this, R.layout.dong_thongbao, arraySP);
        lviewThongBao.setAdapter(adapter);
        BottomNavigationView bt  = findViewById(R.id.bottom_navigation);

        bt.setSelectedItemId(R.id.navigation_notifications);

        bt.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.navigation_home:
                        Intent trangchu = new Intent(ThongBao.this, TrangChu.class);
                        startActivity(trangchu);
                        break;
                    case R.id.navigation_cart:
                        Intent giohang = new Intent(ThongBao.this,GioHang.class);
                        startActivity(giohang);
                        break;
                    case R.id.navigation_chat:
                        Intent trochuyen = new Intent(ThongBao.this,TroChuyen.class);
                        startActivity(trochuyen);
                        break;
                    case R.id.navigation_notifications:

                        break;
                    case R.id.navigation_person:
                        Intent canhan = new Intent(ThongBao.this,NguoiDung.class);
                        startActivity(canhan);
                        break;

                }


                return true;
            }
        });
    }


    private void anhxa() {
        lviewThongBao = (ListView) findViewById(R.id.lvThongBao);
        arraySP = new ArrayList<>();
        arraySP.add(new spThongBao("Bạn đã mua hàng thành công!\n" + "Shop đang đóng gói và vận chuyển",R.drawable.logotbao));
        arraySP.add(new spThongBao("Đơn hàng đã được giao cho bên giao hàng!\n "+" Đơn hàng đã xuất kho ngày 1/11/2021",R.drawable.logotbao));
        arraySP.add(new spThongBao("Bạn đã mua hàng thành công!\n" + "Shop đang đóng gói và vận chuyển",R.drawable.logotbao));

    }
}