package com.example.ducluu.petshop.views;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ducluu.petshop.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ThuocThuY extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thuoc_thu_y);
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
        button = (ImageButton)findViewById(R.id.imgagebtn_seacher_fish_trangchu);
        anhxathuocca();
        adapter = new SanPhamAdapter(this,R.layout.dong_sanpham,arraySP);
        lviewSanPham.setAdapter(null);
        lviewSanPham.setAdapter(adapter);
        button.setBackground(Drawable.createFromPath("#FE9D9D"));
    }
    ImageButton button;
    ListView lviewSanPham;
    ArrayList<spSanPham> arraySP;
    SanPhamAdapter adapter;

    public void onClick(View v) {

        Drawable dr = getResources().getDrawable(R.drawable.button_pressed);
        dr.setColorFilter(Color.parseColor("#FE9D9D"), PorterDuff.Mode.SRC_ATOP);

        switch (v.getId()) {
            case R.id.imagebtn_seacherdog_tramhchu:

                if (button == null) {
                    button = (ImageButton) findViewById(v.getId());

                } else {
                    button.setBackgroundResource(R.drawable.button_pressed);
                    button = (ImageButton) findViewById(v.getId());
                    anhxathuoccho();
                    adapter = new SanPhamAdapter(this,R.layout.dong_sanpham,arraySP);
                    lviewSanPham.setAdapter(null);
                    lviewSanPham.setAdapter(adapter);
                }
                button.setBackgroundDrawable(dr);

                break;

            case R.id.imagebtn_seachercat_trangchu:
                if (button == null) {
                    button = (ImageButton) findViewById(v.getId());

                } else {
                    button.setBackgroundResource(R.drawable.button_pressed);
                    button = (ImageButton) findViewById(v.getId());
                    anhxathuocmeo();
                    adapter = new SanPhamAdapter(this,R.layout.dong_sanpham,arraySP);
                    lviewSanPham.setAdapter(null);
                    lviewSanPham.setAdapter(adapter);
                }
                button.setBackgroundDrawable(dr);

                break;
            case R.id.imagebtn_seacher_bird_trangchu:
                if (button == null) {
                    button = (ImageButton) findViewById(v.getId());
                } else {
                    button.setBackgroundResource(R.drawable.button_pressed);
                    button = (ImageButton) findViewById(v.getId());
                    anhxathuocchim();
                    adapter = new SanPhamAdapter(this,R.layout.dong_sanpham,arraySP);
                    lviewSanPham.setAdapter(null);
                    lviewSanPham.setAdapter(adapter);
                }
                button.setBackgroundDrawable(dr);

                break;
            case R.id.imgagebtn_seacher_fish_trangchu:
                if (button == null) {
                    button = (ImageButton) findViewById(v.getId());
                } else {
                    button.setBackgroundResource(R.drawable.button_pressed);
                    button = (ImageButton) findViewById(v.getId());
                    anhxathuocca();
                    adapter = new SanPhamAdapter(this,R.layout.dong_sanpham,arraySP);
                    lviewSanPham.setAdapter(null);
                    lviewSanPham.setAdapter(adapter);
                }
                button.setBackgroundDrawable(dr);

                break;

            default:
                break;
        }
    }
    private void anhxathuocca() {
        lviewSanPham = (ListView) findViewById(R.id.lvSanPham);
        arraySP = new ArrayList<>();

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest("http://192.168.1.8/Laptrinhdidong_T7/shopthucung/sanpham/thucho.php",
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if(response != null){
                            int ID = 0;
                            String MaTL = "";
                            String Tenthu ="";
                            String giong = "";
                            String gioiting ="";
                            String cannang="";
                            String chieucao="";
                            int tuoi=0;
                            int soluong=0;
                            String mota="";
                            String hinhanh="";
                            int giatien=0;
                            Toast.makeText(ThuocThuY.this, response.toString(),Toast.LENGTH_SHORT).show();

                            for (int i=0;i<response.length();i++) {
                                try {
                                    JSONObject jsonObject = response.getJSONObject(i);
                                    ID = jsonObject.getInt("Id");
                                    MaTL = jsonObject.getString("MaTL");
                                    Tenthu = jsonObject.getString("Ten");
                                    giong = jsonObject.getString("Giong");
                                    gioiting = jsonObject.getString("GioiTinh");
                                    cannang = jsonObject.getString("CanNang");
                                    chieucao = jsonObject.getString("ChieuCao");
                                    tuoi = jsonObject.getInt("Tuoi");
                                    soluong = jsonObject.getInt("soluong");
                                    mota = jsonObject.getString("MoTa");
                                    hinhanh = jsonObject.getString("HinhAnh");
                                    giatien = jsonObject.getInt("GiaTien");

                                    arraySP.add(new spSanPham(Tenthu.toString(), Tenthu.toString(), mota.toString(), R.drawable.thuocca1));

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }
    private void anhxathuocchim() {
        lviewSanPham = (ListView) findViewById(R.id.lvSanPham);
        arraySP = new ArrayList<>();
        arraySP.add(new spSanPham("Thuốc trị tiêu chay","đ1.500.000","trị tiêu chảy, khản giọng, sã cánh",R.drawable.thuocchim));
        arraySP.add(new spSanPham("Thuốc trị tiêu chay","đ1.500.000","trị tiêu chảy, khản giọng, sã cánh",R.drawable.thuocchim));
        arraySP.add(new spSanPham("Thuốc trị tiêu chay","đ1.500.000","trị tiêu chảy, khản giọng, sã cánh",R.drawable.thuocchim));
        arraySP.add(new spSanPham("Thuốc trị tiêu chay","đ1.500.000","trị tiêu chảy, khản giọng, sã cánh",R.drawable.thuocchim));
        arraySP.add(new spSanPham("Thuốc trị tiêu chay","đ1.500.000","trị tiêu chảy, khản giọng, sã cánh",R.drawable.thuocchim));
        arraySP.add(new spSanPham("Thuốc trị tiêu chay","đ1.500.000","trị tiêu chảy, khản giọng, sã cánh",R.drawable.thuocchim));
        arraySP.add(new spSanPham("Thuốc trị tiêu chay","đ1.500.000","trị tiêu chảy, khản giọng, sã cánh",R.drawable.thuocchim));
        arraySP.add(new spSanPham("Thuốc trị tiêu chay","đ1.500.000","trị tiêu chảy, khản giọng, sã cánh",R.drawable.thuocchim));
        arraySP.add(new spSanPham("Thuốc trị tiêu chay","đ1.500.000","trị tiêu chảy, khản giọng, sã cánh",R.drawable.thuocchim));
    }
    private void anhxathuoccho() {
        lviewSanPham = (ListView) findViewById(R.id.lvSanPham);
        arraySP = new ArrayList<>();
        arraySP.add(new spSanPham("Thuốc trị bọ chét","1.500.000","Trị tất cả các loại bọ chét",R.drawable.thuoccho));
        arraySP.add(new spSanPham("Thuốc trị bọ chét","1.500.000","Trị tất cả các loại bọ chét",R.drawable.thuoccho));
        arraySP.add(new spSanPham("Thuốc trị bọ chét","1.500.000","Trị tất cả các loại bọ chét",R.drawable.thuoccho));
        arraySP.add(new spSanPham("Thuốc trị bọ chét","1.500.000","Trị tất cả các loại bọ chét",R.drawable.thuoccho));
        arraySP.add(new spSanPham("Thuốc trị bọ chét","1.500.000","Trị tất cả các loại bọ chét",R.drawable.thuoccho));
        arraySP.add(new spSanPham("Thuốc trị bọ chét","1.500.000","Trị tất cả các loại bọ chét",R.drawable.thuoccho));
        arraySP.add(new spSanPham("Thuốc trị bọ chét","1.500.000","Trị tất cả các loại bọ chét",R.drawable.thuoccho));
        arraySP.add(new spSanPham("Thuốc trị bọ chét","1.500.000","Trị tất cả các loại bọ chét",R.drawable.thuoccho));
        arraySP.add(new spSanPham("Thuốc trị bọ chét","1.500.000","Trị tất cả các loại bọ chét",R.drawable.thuoccho));

    }
    private void anhxathuocmeo() {
        lviewSanPham = (ListView) findViewById(R.id.lvSanPham);
        arraySP = new ArrayList<>();
        arraySP.add(new spSanPham("Thuốc tẩy giun cho mèo","1.500.000","Trị tất cả các loại giun sán",R.drawable.thuocmeo));
        arraySP.add(new spSanPham("Thuốc tẩy giun cho mèo","1.500.000","Trị tất cả các loại giun sán",R.drawable.thuocmeo));
        arraySP.add(new spSanPham("Thuốc tẩy giun cho mèo","1.500.000","Trị tất cả các loại giun sán",R.drawable.thuocmeo));
        arraySP.add(new spSanPham("Thuốc tẩy giun cho mèo","1.500.000","Trị tất cả các loại giun sán",R.drawable.thuocmeo));
        arraySP.add(new spSanPham("Thuốc tẩy giun cho mèo","1.500.000","Trị tất cả các loại giun sán",R.drawable.thuocmeo));
        arraySP.add(new spSanPham("Thuốc tẩy giun cho mèo","1.500.000","Trị tất cả các loại giun sán",R.drawable.thuocmeo));
        arraySP.add(new spSanPham("Thuốc tẩy giun cho mèo","1.500.000","Trị tất cả các loại giun sán",R.drawable.thuocmeo));
        arraySP.add(new spSanPham("Thuốc tẩy giun cho mèo","1.500.000","Trị tất cả các loại giun sán",R.drawable.thuocmeo));
        arraySP.add(new spSanPham("Thuốc tẩy giun cho mèo","1.500.000","Trị tất cả các loại giun sán",R.drawable.thuocmeo));
        arraySP.add(new spSanPham("Thuốc tẩy giun cho mèo","1.500.000","Trị tất cả các loại giun sán",R.drawable.thuocmeo));

    }
}