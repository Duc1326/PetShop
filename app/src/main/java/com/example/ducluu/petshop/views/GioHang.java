package com.example.ducluu.petshop.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ducluu.petshop.Helper.ChangeNumberItemListener;
import com.example.ducluu.petshop.Helper.ManagementCard;
import com.example.ducluu.petshop.R;
import com.example.ducluu.petshop.adapter.GiohangAdapter;
import com.example.ducluu.petshop.databinding.ActivityGiohangBinding;
import com.example.ducluu.petshop.model.MonAn;

import java.text.NumberFormat;
import java.util.Locale;

public class GioHang extends AppCompatActivity {

    ActivityGiohangBinding binding;
    MonAn monAn = null;

    TextView btnBack, tvTong, emptyTxt;
    TextView btnOrder;

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCard managementCard;
    GiohangAdapter giohangAdapter;
    String tong_format;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGiohangBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        managementCard = new ManagementCard(this);

        cainaylaNut();
        AnhXa();
        initList();
        CalculateCard();
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
                startActivity(new Intent(GioHang.this, MyOrder.class));
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