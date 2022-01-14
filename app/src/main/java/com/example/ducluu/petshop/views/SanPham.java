package com.example.ducluu.petshop.views;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ducluu.petshop.R;
import com.example.ducluu.petshop.adapter.thucungchoAdapter;
import com.example.ducluu.petshop.databinding.ActivitySanPhamBinding;
import com.example.ducluu.petshop.model.thucung;
import com.example.ducluu.petshop.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SanPham extends AppCompatActivity {

     ActivitySanPhamBinding binding;
    String urlBase= Utils.BASE_URL;
    String url = Utils.BASE_URL+"/shopthucung/shopthucung/thu/listsanpham.php";

    thucungchoAdapter thucungchoAdapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    JsonArrayRequest request;
    RequestQueue requestQueue;
    ArrayList<thucung> thucungs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySanPhamBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        thucungs = new ArrayList<>();
        recyclerView = findViewById(R.id.lvmonan);
        recyclerView.setHasFixedSize(true);
        layoutManager =new LinearLayoutManager(SanPham.this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        call_json();


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
                thucungchoAdapter = new thucungchoAdapter(SanPham.this,thucungs);
                recyclerView.setAdapter(thucungchoAdapter);
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


