package com.example.ducluu.petshop.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ducluu.petshop.R;

import org.json.JSONArray;

public class DangNhap extends AppCompatActivity {
    Button btn_login;
    ImageButton btn_back;
    TextView  foget_pass;
    String url = "http://192.168.1.8/Android/list_product/product.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        getData(url);
        foget_pass = findViewById(R.id.foget_pass);
        btn_login = findViewById(R.id.btn_center_login_dangnhap);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData(url);
//                Intent intent = new Intent(DangNhap.this, TrangChu.class);
//                startActivity(intent);
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



    public void getData(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "http://192.168.1.8/Android/list_product/product.php", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        Toast.makeText(DangNhap.this,  response.toString(), Toast.LENGTH_LONG).show();


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(DangNhap.this, error.toString(), Toast.LENGTH_LONG).show();
                        Log.e("abc",error.toString());
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }
}