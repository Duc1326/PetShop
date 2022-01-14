package com.example.ducluu.petshop.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ducluu.petshop.databinding.ActivitiPhukienBinding;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ducluu.petshop.R;
import com.example.ducluu.petshop.adapter.thucungchoAdapter;
import com.example.ducluu.petshop.databinding.ActivityThucAnBinding;
import com.example.ducluu.petshop.model.thucung;
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
ActivitiPhukienBinding binding;
    String urlBase= Utils.BASE_URL;
    String url = Utils.BASE_URL+"/shopthucung/shopthucung/thu/listsanpham.php";

    com.example.ducluu.petshop.adapter.thucungchoAdapter thucungchoAdapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    JsonArrayRequest request;
    RequestQueue requestQueue;
    ArrayList<thucung> thucungs;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitiPhukienBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        setContentView(R.layout.activity_thuc_an);
        thucungs = new ArrayList<>();
        recyclerView = findViewById(R.id.lvmonan);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(PhuKien1.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        call_json();


        //        setContentView(R.layout.activiti_phukien);
//        anhxa();
//       adapter = new SanPhamAdapter(this, R.layout.dong_sanpham, arrayTB);
//        lviewThongBao.setAdapter(adapter);
        BottomNavigationView bt = findViewById(R.id.bottom_navigation);

        bt.setSelectedItemId(R.id.navigation_notifications);

        bt.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Intent trangchu = new Intent(PhuKien1.this, TrangChu.class);
                        startActivity(trangchu);
                        break;
                    case R.id.navigation_cart:
                        Intent giohang = new Intent(PhuKien1.this, GioHang.class);
                        startActivity(giohang);
                        break;
                    case R.id.navigation_chat:
                        Intent trochuyen = new Intent(PhuKien1.this, TroChuyen.class);
                        startActivity(trochuyen);
                        break;
                    case R.id.navigation_notifications:

                        break;
                    case R.id.navigation_person:
                        Intent canhan = new Intent(PhuKien1.this, NguoiDung.class);
                        startActivity(canhan);
                        break;

                }


                return true;
            }
        });
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
                thucungchoAdapter = new thucungchoAdapter(PhuKien1.this, thucungs);
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
        requestQueue = Volley.newRequestQueue(PhuKien1.this);
        requestQueue.add(request);

    }

    }
//private void anhxa(){
//        lviewThongBao =(ListView) findViewById(R.id.lvThongBao);
//        arrayTB = new ArrayList<>();
//        arrayTB.add(new spSanPham("Lồng chim","đ3.400.000","lồng chim cho chim từ 300g", R.drawable.cho1));
//    arrayTB.add(new spSanPham("vòng cỗ chó","đ3.400.000","Vòng cỗ cho chó", R.drawable.cho1));
//    arrayTB.add(new spSanPham("Hồ cá","đ3.400.000","hồ cá bằng kính chưa đc 10 lít nước", R.drawable.cho1));
//}


