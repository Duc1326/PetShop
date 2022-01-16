package com.example.ducluu.petshop.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

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
import com.example.ducluu.petshop.model.MonAn;
import com.example.ducluu.petshop.utils.Utils;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PhuKien1 extends AppCompatActivity {
    //    ListView lviewThongBao;
//    ArrayList<spSanPham> arrayTB;
//    SanPhamAdapter adapter ;
    ActivitySanPhamBinding binding;

    String url = Utils.BASE_URL+"/ltddshopthucung/sanpham/phukiencho.php";

    MonAnListAdapter monAnListAdapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    JsonArrayRequest request;
    RequestQueue requestQueue;
    ArrayList<MonAn> monAnList;
    ImageButton bt1,bt2,bt3,bt4;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiti_phukien);

        binding = ActivitySanPhamBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        monAnList = new ArrayList<>();
        recyclerView = findViewById(R.id.lvmonan);
        recyclerView.setHasFixedSize(true);
        layoutManager =new LinearLayoutManager(PhuKien1.this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        call_json();
        getViews();

//        anhxa();
//       adapter = new SanPhamAdapter(this, R.layout.dong_sanpham, arrayTB);
//        lviewThongBao.setAdapter(adapter);
//        BottomNavigationView bt  = findViewById(R.id.bottom_navigation);

//        bt.setSelectedItemId(R.id.navigation_notifications);
//
//        bt.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                switch (item.getItemId()){
//                    case R.id.navigation_home:
//                        Intent trangchu = new Intent(PhuKien1.this, TrangChu.class);
//                        startActivity(trangchu);
//                        break;
//                    case R.id.navigation_cart:
//                        Intent giohang = new Intent(PhuKien1.this,GioHang.class);
//                        startActivity(giohang);
//                        break;
//                    case R.id.navigation_chat:
//                        Intent trochuyen = new Intent(PhuKien1.this,TroChuyen.class);
//                        startActivity(trochuyen);
//                        break;
//                    case R.id.navigation_notifications:
//
//                        break;
//                    case R.id.navigation_person:
//                        Intent canhan = new Intent(PhuKien1.this,NguoiDung.class);
//                        startActivity(canhan);
//                        break;
//
//                }
//
//
//                return true;
//            }
//        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monAnListAdapter.clearApplications();
                recyclerView.setAdapter(monAnListAdapter);
                url = Utils.BASE_URL+"ltdd/shopthucung/sanpham/phukiencho.php";
                call_json();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monAnListAdapter.clearApplications();
                recyclerView.setAdapter(monAnListAdapter);
                url = Utils.BASE_URL+"ltdd/shopthucung/sanpham/phukienmeo.php";
                call_json();
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monAnListAdapter.clearApplications();
                recyclerView.setAdapter(monAnListAdapter);
                url = Utils.BASE_URL+"ltdd/shopthucung/sanpham/phukienchim.php";
                call_json();
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monAnListAdapter.clearApplications();
                recyclerView.setAdapter(monAnListAdapter);
                url = Utils.BASE_URL+"ltdd/shopthucung/sanpham/phukienca.php";
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
//private void anhxa(){
//        lviewThongBao =(ListView) findViewById(R.id.lvThongBao);
//        arrayTB = new ArrayList<>();
//        arrayTB.add(new spSanPham("Lồng chim","đ3.400.000","lồng chim cho chim từ 300g", R.drawable.cho1));
//    arrayTB.add(new spSanPham("vòng cỗ chó","đ3.400.000","Vòng cỗ cho chó", R.drawable.cho1));
//    arrayTB.add(new spSanPham("Hồ cá","đ3.400.000","hồ cá bằng kính chưa đc 10 lít nước", R.drawable.cho1));
//}

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
                monAnListAdapter = new MonAnListAdapter(PhuKien1.this, monAnList);
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
        requestQueue = Volley.newRequestQueue(PhuKien1.this);
        requestQueue.add(request);
    }
}