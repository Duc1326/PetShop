package com.example.ducluu.petshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class DangKy extends AppCompatActivity {
    Button btn_dangnhap;
    ImageButton btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        btn_back = findViewById(R.id.image_back_dangky);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(DangKy.this, Dangnhap_Dangki.class);
                startActivity(back);
            }
        });
    }
}