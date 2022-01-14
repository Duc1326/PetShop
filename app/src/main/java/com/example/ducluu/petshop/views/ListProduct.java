package com.example.ducluu.petshop.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ducluu.petshop.R;
import com.example.ducluu.petshop.adapter.MonAnListAdapter;
import com.example.ducluu.petshop.databinding.ActivityListProductBinding;
import com.example.ducluu.petshop.model.MonAn;
import com.example.ducluu.petshop.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListProduct extends AppCompatActivity {

    ActivityListProductBinding binding;

    TextView btnBackList;
    CardView cardView;

    String urlBase= Utils.BASE_URL.concat("Laptrinhdidong_T7/");
    String url = Utils.BASE_URL+"Laptrinhdidong_T7/Android/list_product/product.php";

    MonAnListAdapter monAnListAdapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    JsonArrayRequest request;
    RequestQueue requestQueue;
    ArrayList<MonAn> monAnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        cainaylaNut();

        monAnList = new ArrayList<>();
        recyclerView = findViewById(R.id.lvmonan);
        recyclerView.setHasFixedSize(true);
        layoutManager =new LinearLayoutManager(ListProduct.this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        call_json();

    }

    private void call_json() {

        request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i=0;i<response.length();i++){
                    MonAn getMonAnAdapter = new MonAn();
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = response.getJSONObject(i);

                        getMonAnAdapter.setTenMon(jsonObject.getString("nameFood"));
                        getMonAnAdapter.setGia(jsonObject.getInt("price"));
                        getMonAnAdapter.setSao(jsonObject.getDouble("star"));
                        getMonAnAdapter.setMoTa(jsonObject.getString("description"));
                        getMonAnAdapter.setCalories(jsonObject.getInt("calories"));
                        getMonAnAdapter.setMaSP(jsonObject.getInt("id_food"));

                        getMonAnAdapter.setHinhMon(urlBase.concat(jsonObject.getString("imgFood")));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    monAnList.add(getMonAnAdapter);
                }
                monAnListAdapter = new MonAnListAdapter(ListProduct.this,monAnList);
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
        requestQueue = Volley.newRequestQueue(ListProduct.this);
        requestQueue.add(request);
    }



    private void cainaylaNut() {
        btnBackList=(TextView) findViewById(R.id.btnBackList);
        btnBackList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListProduct.this, TrangChu.class));
            }
        });
        cardView=(CardView) findViewById(R.id.cardView);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListProduct.this, TrangChu.class));
            }
        });
    }
}