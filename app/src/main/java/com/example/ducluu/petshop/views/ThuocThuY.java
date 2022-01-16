package com.example.ducluu.petshop.views;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ducluu.petshop.R;
import com.example.ducluu.petshop.adapter.MonAnListAdapter;
import com.example.ducluu.petshop.databinding.ActivitySanPhamBinding;
import com.example.ducluu.petshop.databinding.ActivityThuocThuYBinding;
import com.example.ducluu.petshop.model.MonAn;
import com.example.ducluu.petshop.utils.Utils;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ThuocThuY extends AppCompatActivity {

    ActivityThuocThuYBinding binding;

    String url = Utils.BASE_URL+"Laptrinhdidong_T7/shopthucung/sanpham/thuoccho.php";

    MonAnListAdapter monAnListAdapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    JsonArrayRequest request;
    RequestQueue requestQueue;
    ArrayList<MonAn> monAnList;
    ImageButton bt1,bt2,bt3,bt4;
    ImageButton btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thuoc_thu_y);

        binding = ActivityThuocThuYBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        monAnList = new ArrayList<>();
        recyclerView = findViewById(R.id.lvmonan);
        recyclerView.setHasFixedSize(true);
        layoutManager =new LinearLayoutManager(ThuocThuY.this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        call_json();
        getViews();

        btnback = findViewById(R.id.btnBack);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Trangchu = new Intent(ThuocThuY.this, TrangChu.class);
                startActivity(Trangchu);
            }
        });

        BottomNavigationView bt  = findViewById(R.id.bottom_navigation);

        bt.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.navigation_home:
                        Intent trangchu = new Intent(ThuocThuY.this, TrangChu.class);
                        startActivity(trangchu);
                        break;
                    case R.id.navigation_cart:
                        Intent giohang = new Intent(ThuocThuY.this,GioHang.class);
                        startActivity(giohang);
                        break;
                    case R.id.navigation_chat:
                        Intent trochuyen = new Intent(ThuocThuY.this,TroChuyen.class);
                        startActivity(trochuyen);
                        break;
                    case R.id.navigation_notifications:
                        Intent thongbao = new Intent(ThuocThuY.this,ThongBao.class);
                        startActivity(thongbao);
                        break;
                    case R.id.navigation_person:
                        Intent canhan = new Intent(ThuocThuY.this,NguoiDung.class);
                        startActivity(canhan);
                        break;

                }


                return true;
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monAnListAdapter.clearApplications();
                recyclerView.setAdapter(monAnListAdapter);
                url = Utils.BASE_URL+"Laptrinhdidong_T7/shopthucung/sanpham/thuoccho.php";
                call_json();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monAnListAdapter.clearApplications();
                recyclerView.setAdapter(monAnListAdapter);
                url = Utils.BASE_URL+"Laptrinhdidong_T7/shopthucung/sanpham/thuocmeo.php";
                call_json();
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monAnListAdapter.clearApplications();
                recyclerView.setAdapter(monAnListAdapter);
                url = Utils.BASE_URL+"Laptrinhdidong_T7/shopthucung/sanpham/thuocchim.php";
                call_json();
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monAnListAdapter.clearApplications();
                recyclerView.setAdapter(monAnListAdapter);
                url = Utils.BASE_URL+"Laptrinhdidong_T7/shopthucung/sanpham/thuocca.php";
                call_json();
            }
        });
    }
    private void getViews() {
        bt1 = findViewById(R.id.imagebtn_seacherdog_tramhchu);
        bt2= findViewById(R.id.imagebtn_seachercat_trangchu);
        bt3 = findViewById(R.id.imagebtn_seacher_bird_trangchu);
        bt4 = findViewById(R.id.imgagebtn_seacher_fish_trangchu);
    }

    private void call_json() {

        request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0; i < response.length(); i++) {
                    MonAn getMonAnAdapter = new MonAn();
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = response.getJSONObject(i);

                        getMonAnAdapter.setTenMon(jsonObject.getString("Ten"));
                        getMonAnAdapter.setGia(jsonObject.getInt("GiaTien"));

                        getMonAnAdapter.setMoTa(jsonObject.getString("MoTa"));
                        getMonAnAdapter.setSao(jsonObject.getDouble("soluong"));
                        getMonAnAdapter.setTuoi(jsonObject.getInt("Tuoi"));
                        getMonAnAdapter.setMaSP(jsonObject.getInt("Id"));
                        getMonAnAdapter.setGiong(jsonObject.getString("Giong"));
                        getMonAnAdapter.setCanNang(jsonObject.getString("CanNang"));

                        getMonAnAdapter.setSao(jsonObject.getDouble("soluong"));
                        getMonAnAdapter.setMoTa(jsonObject.getString("MoTa"));
                        //getMonAnAdapter.setCalories(jsonObject.getInt("Tuoi"));
                        getMonAnAdapter.setMaSP(jsonObject.getInt("Id"));

                        getMonAnAdapter.setHinhMon(jsonObject.getString("HinhAnh"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    monAnList.add(getMonAnAdapter);
                }
                monAnListAdapter = new MonAnListAdapter(ThuocThuY.this, monAnList);
                recyclerView.setAdapter(monAnListAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("a", error.toString());
//                Toast.makeText(ListProduct.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue = Volley.newRequestQueue(ThuocThuY.this);
        requestQueue.add(request);
    }

}