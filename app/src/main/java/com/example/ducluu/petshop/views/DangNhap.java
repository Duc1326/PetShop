package com.example.ducluu.petshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class DangNhap extends AppCompatActivity {
    Button btn_login;
    ImageButton btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        btn_login = findViewById(R.id.btn_center_login_dangnhap);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangNhap.this, TrangChu.class);
                startActivity(intent);
            }
        });

        btn_back = findViewById(R.id.image_back_dangnhap);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(DangNhap.this, Dangnhap_Dangki.class);
                startActivity(back);
            }
        });

    }
}