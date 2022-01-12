package com.example.ducluu.petshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dangnhap_Dangki extends AppCompatActivity {
    Button btn_dangnhap,btn_dangki;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap_dangki);

        btn_dangnhap=findViewById(R.id.dangnhap_dangnhapdangki);
        btn_dangki=findViewById(R.id.dangki_dangnhapdangki);

        btn_dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dangnhap = new Intent(Dangnhap_Dangki.this,DangNhap.class);
                startActivity(dangnhap);
            }
        });

        btn_dangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dangky  = new Intent(Dangnhap_Dangki.this,DangKy.class);
                startActivity(dangky);
            }
        });

    }
}