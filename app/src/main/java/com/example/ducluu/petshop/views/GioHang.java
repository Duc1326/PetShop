package com.example.ducluu.petshop.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ducluu.petshop.Helper.ChangeNumberItemListener;
import com.example.ducluu.petshop.Helper.ManagementCard;
import com.example.ducluu.petshop.R;
import com.example.ducluu.petshop.adapter.GiohangAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.text.NumberFormat;
import java.util.Locale;

public class GioHang extends AppCompatActivity {
    TextView btnBack, tvTong, emptyTxt;
    TextView btnOrder;

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCard managementCard;

    String tong_format;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giohang);

        BottomNavigationView bt = findViewById(R.id.bottom_navigation);

        bt.setSelectedItemId(R.id.navigation_cart);

        bt.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Intent trangchu = new Intent(GioHang.this, TrangChu.class);
                        startActivity(trangchu);
                        break;
                    case R.id.navigation_cart:

                        break;
                    case R.id.navigation_chat:
                        Intent trochuyen = new Intent(GioHang.this, TroChuyen.class);
                        startActivity(trochuyen);
                        break;
                    case R.id.navigation_notifications:
                        Intent thongbao = new Intent(GioHang.this, ThongBao.class);
                        startActivity(thongbao);
                        break;
                    case R.id.navigation_person:
                        Intent canhan = new Intent(GioHang.this, NguoiDung.class);
                        startActivity(canhan);
                        break;
                }
                return true;
            }
        });

    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter = new GiohangAdapter(managementCard.getListCard(), this, new ChangeNumberItemListener() {
            @Override
            public void changed() {
                CalculateCard();
            }
        });
        recyclerViewList.setAdapter(adapter);
        if (managementCard.getListCard().isEmpty()) {
            emptyTxt.setVisibility(View.VISIBLE);
        } else {
            emptyTxt.setVisibility(View.GONE);
        }

    }

    private void cainaylaNut() {
        btnBack = (TextView) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GioHang.this, TrangChu.class));
            }
        });
        btnOrder = (TextView) findViewById(R.id.btnOrder);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GioHang.this, ThanhToan.class));
            }
        });

    }

    private void CalculateCard() {

        tong_format = NumberFormat.getNumberInstance(Locale.US).format(managementCard.getTotalFee());
        tvTong.setText(tong_format + "đ");
    }

    private void AnhXa() {
        emptyTxt = (TextView) findViewById(R.id.emptyTxt);
        tvTong = (TextView) findViewById(R.id.tvTong);
        recyclerViewList = findViewById(R.id.lvGiohang);
    }

}