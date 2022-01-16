package com.example.ducluu.petshop.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

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
import com.example.ducluu.petshop.adapter.thucungchoAdapter;
import com.example.ducluu.petshop.databinding.ActivitySanPhamBinding;
import com.example.ducluu.petshop.model.MonAn;
import com.example.ducluu.petshop.model.thucung;
import com.example.ducluu.petshop.utils.Utils;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SanPham extends AppCompatActivity {


     ActivitySanPhamBinding binding;

    String url = Utils.BASE_URL+"ltdd/shopthucung/sanpham/thucho.php";



    MonAnListAdapter monAnListAdapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    JsonArrayRequest request;
    RequestQueue requestQueue;
    ArrayList<MonAn> monAnList;
    ImageButton bt1,bt2,bt3,bt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySanPhamBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        monAnList = new ArrayList<>();
        recyclerView = findViewById(R.id.lvmonan);
        recyclerView.setHasFixedSize(true);
        layoutManager =new LinearLayoutManager(SanPham.this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        call_json();
        getViews();



//        Intent intent = getIntent();
//        Integer id = intent.getIntExtra("dulieu",1);
//
//        switch (id){
//            case 1: button = findViewById(R.id.btn);
//
//                break;
//            case 2:
//                button = findViewById(R.id.btn1);
//
//                break;
//            case 3:
//                button = findViewById(R.id.btn2);
//
//                break;
//            case 4:
//                button = findViewById(R.id.btn3);
//
//                break;
//            default:
//                button = findViewById(R.id.btn);
//
//                break;
//        }
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monAnListAdapter.clearApplications();
                recyclerView.setAdapter(monAnListAdapter);
                url = Utils.BASE_URL+"ltdd/shopthucung/sanpham/thucho.php";
                call_json();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monAnListAdapter.clearApplications();
                recyclerView.setAdapter(monAnListAdapter);
                url = Utils.BASE_URL+"ltdd/shopthucung/sanpham/thumeo.php";
                call_json();
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monAnListAdapter.clearApplications();
                recyclerView.setAdapter(monAnListAdapter);
                url = Utils.BASE_URL+"ltdd/shopthucung/sanpham/thuchim.php";
                call_json();
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monAnListAdapter.clearApplications();
                recyclerView.setAdapter(monAnListAdapter);
                url = Utils.BASE_URL+"ltdd/shopthucung/sanpham/thuca.php";
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


//    public void onClick(View v) {
//
//        Drawable dr = getResources().getDrawable(R.drawable.button_pressed);
//        dr.setColorFilter(Color.parseColor("#FE9D9D"), PorterDuff.Mode.SRC_ATOP);
//
//        switch (v.getId()) {
//            case R.id.btn:
//
//                if (button == null) {
//                    button = (Button) findViewById(v.getId());
//
//                } else {
//                    button.setBackgroundResource(R.drawable.button_pressed);
//                    button = (Button) findViewById(v.getId());
//
//
//
//                }
//                button.setBackgroundDrawable(dr);
//
//                break;
//
//            case R.id.btn1:
//                if (button == null) {
//                    button = (Button) findViewById(v.getId());
//
//
//                } else {
//                    button.setBackgroundResource(R.drawable.button_pressed);
//                    button = (Button) findViewById(v.getId());
//
//
//                }
//                button.setBackgroundDrawable(dr);
//
//                break;
//            case R.id.btn2:
//                if (button == null) {
//                    button = (Button) findViewById(v.getId());
//                } else {
//                    button.setBackgroundResource(R.drawable.button_pressed);
//                    button = (Button) findViewById(v.getId());
//
//
//
//                }
//                button.setBackgroundDrawable(dr);
//
//                break;
//            case R.id.btn3:
//                if (button == null) {
//                    button = (Button) findViewById(v.getId());
//                } else {
//                    button.setBackgroundResource(R.drawable.button_pressed);
//                    button = (Button) findViewById(v.getId());
//
//
//                }
//                button.setBackgroundDrawable(dr);
//
//                break;
//            case R.id.txtxem:
//                Intent chitiet = new Intent(SanPham.this, ThongTinsp.class);
//                startActivity(chitiet);
//                break;
//            case R.id.btgio:
//                Intent giohang = new Intent(SanPham.this, GioHang.class);
//                startActivity(giohang);
//                break;
//            case R.id.btmuan:
//                Intent thanhtoan = new Intent(SanPham.this, ThanhToan.class);
//                startActivity(thanhtoan);
//                break;
//
//            default:
//                break;
//        }
//    }


    private void call_json() {

        request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i=0;i<response.length();i++){
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
                monAnListAdapter = new MonAnListAdapter(SanPham.this,monAnList);
                recyclerView.setAdapter(monAnListAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("a",error.toString());
//                Toast.makeText(ListProduct.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue = Volley.newRequestQueue(SanPham.this);
        requestQueue.add(request);
    }



}

