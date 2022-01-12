package com.example.ducluu.petshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class CaNhan extends AppCompatActivity {
    ImageButton ima_btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ca_nhan);


        ima_btn_back = findViewById(R.id.image_btn_back_canhan);

        ima_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CaNhan.this, NguoiDung.class);
                startActivity(intent);

            }
        });
    }
}