package com.example.ducluu.petshop.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ducluu.petshop.R;
import com.example.ducluu.petshop.adapter.thucungchoAdapter;
import com.example.ducluu.petshop.databinding.ActivitySanPhamBinding;
import com.example.ducluu.petshop.databinding.ActivityThucAnBinding;
import com.example.ducluu.petshop.model.thucung;
import com.example.ducluu.petshop.utils.Utils;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ThucAn extends AppCompatActivity {
    ActivityThucAnBinding binding;
    String urlBase = Utils.BASE_URL;
    String url = Utils.BASE_URL + "/shopthucung/shopthucung/thu/listsanpham.php";

    com.example.ducluu.petshop.adapter.thucungchoAdapter thucungchoAdapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    JsonArrayRequest request;
    RequestQueue requestQueue;
    ArrayList<thucung> thucungs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityThucAnBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        setContentView(R.layout.activity_thuc_an);
        thucungs = new ArrayList<>();
        recyclerView = findViewById(R.id.lvmonan);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(ThucAn.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        call_json();
    }

    private void call_json() {
        request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0; i < response.length(); i++) {
                    thucung getMonAnAdapter = new thucung();
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = response.getJSONObject(i);

                        getMonAnAdapter.setTenthu(jsonObject.getString("Ten"));
                        getMonAnAdapter.setGiatien(jsonObject.getInt("GiaTien"));
                        getMonAnAdapter.setSoluong(jsonObject.getInt("soluong"));
                        getMonAnAdapter.setMota(jsonObject.getString("MoTa"));
                        getMonAnAdapter.setTuoi(jsonObject.getInt("Tuoi"));
                        getMonAnAdapter.setId(jsonObject.getInt("Id"));

                        getMonAnAdapter.setHinhMon(jsonObject.getString("HinhAnh"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    thucungs.add(getMonAnAdapter);
                }
                thucungchoAdapter = new thucungchoAdapter(ThucAn.this, thucungs);
                recyclerView.setAdapter(thucungchoAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("a", error.toString());
//                Toast.makeText(ListProduct.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue = Volley.newRequestQueue(ThucAn.this);
        requestQueue.add(request);

    }}

//
//    //        setContentView(R.layout.activity_thuc_an);
//    BottomNavigationView bt = findViewById(R.id.bottom_navigation);
//
//        bt.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener()
//
//    private final GioHangAdapter item;
//
//    {
//        public boolean onNavigationItemSelected (@NonNull MenuItem item){
//
//        switch (item.getItemId()) {
//            case R.id.navigation_home:
//                Intent trangchu = new Intent(ThucAn.this, TrangChu.class);
//                startActivity(trangchu);
//                break;
//            case R.id.navigation_cart:
//                Intent giohang = new Intent(ThucAn.this, GioHang.class);
//                startActivity(giohang);
//                break;
//            case R.id.navigation_chat:
//                Intent trochuyen = new Intent(ThucAn.this, TroChuyen.class);
//                startActivity(trochuyen);
//                break;
//            case R.id.navigation_notifications:
//                Intent thongbao = new Intent(ThucAn.this, ThongBao.class);
//                startActivity(thongbao);
//                break;
//            case R.id.navigation_person:
//                Intent canhan = new Intent(ThucAn.this, NguoiDung.class);
//                startActivity(canhan);
//                break;
//
//        }
//
//
//        return true;
//    }
//    });
//}
//
//        button = (ImageButton) findViewById(R.id.imagebtn_seacherdog_tramhchu);
//        anhxacho();
//        adapter = new SanPhamAdapter(this,R.layout.dong_sanpham,arraySP);
//        lviewSanPham.setAdapter(null);
//        lviewSanPham.setAdapter(adapter);
//        button.setBackground(Drawable.createFromPath("#FE9D9D"));
//    }
//  ImageButton button;
//    ListView lviewSanPham;
//    ArrayList<spSanPham> arraySP;
//    SanPhamAdapter adapter;
//
//    public void onClick(View v) {
//
//        Drawable dr = getResources().getDrawable(R.drawable.button_pressed);
//        dr.setColorFilter(Color.parseColor("#FE9D9D"), PorterDuff.Mode.SRC_ATOP);
//
//        switch (v.getId()) {
//            case R.id.imagebtn_seacherdog_tramhchu:
//
//                if (button == null) {
//                    button = (ImageButton) findViewById(v.getId());
//
//                } else {
//                    button.setBackgroundResource(R.drawable.button_pressed);
//                    button = (ImageButton) findViewById(v.getId());
//                    anhxacho();
//                    adapter = new SanPhamAdapter(this,R.layout.dong_sanpham,arraySP);
//                    lviewSanPham.setAdapter(null);
//                    lviewSanPham.setAdapter(adapter);
//                }
//                button.setBackgroundDrawable(dr);
//
//                break;
//
//            case R.id.imagebtn_seachercat_trangchu:
//                if (button == null) {
//                    button = (ImageButton) findViewById(v.getId());
//
//                } else {
//                    button.setBackgroundResource(R.drawable.button_pressed);
//                    button = (ImageButton) findViewById(v.getId());
//                    anhxameo();
//                    adapter = new SanPhamAdapter(this,R.layout.dong_sanpham,arraySP);
//                    lviewSanPham.setAdapter(null);
//                    lviewSanPham.setAdapter(adapter);
//                }
//                button.setBackgroundDrawable(dr);
//
//                break;
//            case R.id.imagebtn_seacher_bird_trangchu:
//                if (button == null) {
//                    button = (ImageButton) findViewById(v.getId());
//                } else {
//                    button.setBackgroundResource(R.drawable.button_pressed);
//                    button = (ImageButton) findViewById(v.getId());
//                    anhxachim();
//                    adapter = new SanPhamAdapter(this,R.layout.dong_sanpham,arraySP);
//                    lviewSanPham.setAdapter(null);
//                    lviewSanPham.setAdapter(adapter);
//                }
//                button.setBackgroundDrawable(dr);
//
//                break;
//            case R.id.imgagebtn_seacher_fish_trangchu:
//                if (button == null) {
//                    button = (ImageButton) findViewById(v.getId());
//                } else {
//                    button.setBackgroundResource(R.drawable.button_pressed);
//                    button = (ImageButton) findViewById(v.getId());
//                    anhxaca();
//                    adapter = new SanPhamAdapter(this,R.layout.dong_sanpham,arraySP);
//                    lviewSanPham.setAdapter(null);
//                    lviewSanPham.setAdapter(adapter);
//                }
//                button.setBackgroundDrawable(dr);
//
//                break;
//
//            default:
//                break;
//        }
//    }
//    private void anhxaca(){
//        lviewSanPham =(ListView) findViewById(R.id.lvSanPham);
//        arraySP= new ArrayList<>();
//        arraySP.add(new spSanPham("Thức ăn cho cá","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucanca));
//        arraySP.add(new spSanPham("Thức ăn cho cá","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucanca));
//        arraySP.add(new spSanPham("Thức ăn cho cá","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucanca));
//        arraySP.add(new spSanPham("Thức ăn cho cá","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucanca));
//        arraySP.add(new spSanPham("Thức ăn cho cá","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucanca));
//
//    }
//    private void anhxacho(){
//        lviewSanPham =(ListView) findViewById(R.id.lvSanPham);
//        arraySP= new ArrayList<>();
//        arraySP.add(new spSanPham("Thức ăn cho chó","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucancho));
//        arraySP.add(new spSanPham("Thức ăn cho chó","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucancho));
//        arraySP.add(new spSanPham("Thức ăn cho chó","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucancho));
//        arraySP.add(new spSanPham("Thức ăn cho chó","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucancho));
//        arraySP.add(new spSanPham("Thức ăn cho chó","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucancho));
//
//    }
//    private void anhxachim(){
//        lviewSanPham =(ListView) findViewById(R.id.lvSanPham);
//        arraySP= new ArrayList<>();
//        arraySP.add(new spSanPham("Thức ăn cho chim","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucanchim));
//        arraySP.add(new spSanPham("Thức ăn cho chim","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucanchim));
//        arraySP.add(new spSanPham("Thức ăn cho chim","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucanchim));
//        arraySP.add(new spSanPham("Thức ăn cho chim","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucanchim));
//        arraySP.add(new spSanPham("Thức ăn cho chim","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucanchim));
//
//    }
//    private void anhxameo(){
//        lviewSanPham =(ListView) findViewById(R.id.lvSanPham);
//        arraySP= new ArrayList<>();
//        arraySP.add(new spSanPham("Thức ăn cho mèo","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucanmeo));
//        arraySP.add(new spSanPham("Thức ăn cho mèo","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucanmeo));
//        arraySP.add(new spSanPham("Thức ăn cho mèo","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucanmeo));
//        arraySP.add(new spSanPham("Thức ăn cho mèo","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucanmeo));
//        arraySP.add(new spSanPham("Thức ăn cho mèo","đ1.500.000","Mô tả: trị các loại bọ chét",R.drawable.thucanmeo));
//
//    }
//}