package com.example.ducluu.petshop.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ducluu.petshop.adapter.LichSuApdapter;
import com.example.ducluu.petshop.App.SessionManager;
import com.example.ducluu.petshop.model.LichSu;
import com.example.ducluu.petshop.R;
import com.example.ducluu.petshop.databinding.ActivityHistoryBinding;
import com.example.ducluu.petshop.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class History extends AppCompatActivity {

    private static final String TAG = MyOrder.class.getSimpleName();

    ActivityHistoryBinding binding;

    String url = Utils.BASE_URL+"Laptrinhdidong_T7/shopthucung/History.php";
    String urlBase= Utils.BASE_URL;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<LichSu> lichsuList;
    LichSuApdapter lichSuApdapter;
    StringRequest request;
    RequestQueue requestQueue;

    ImageButton btnBack;

    String getId;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHistoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sessionManager = new SessionManager(this);
        HashMap<String, String> user = sessionManager.getUserDetail();
        getId = user.get(sessionManager.ID);



        lichsuList = new ArrayList<>();
        recyclerView = findViewById(R.id.recHistory);
        recyclerView.setHasFixedSize(true);
        layoutManager =new LinearLayoutManager(History.this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        call_json();

        btnBack = findViewById( R.id.btnBackList);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(History.this, NguoiDung.class);
                startActivity(back);
            }
        });



    }

    private void call_json() {

        request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray j = new JSONArray(response);

                    for (int i = 0; i < j.length(); i++) {

                        JSONObject jsonObject = null;
                        jsonObject = j.getJSONObject(i);

                        LichSu getLichSuAdapter = new LichSu();

                        getLichSuAdapter.setNameFood(jsonObject.getString("Ten"));
                        getLichSuAdapter.setDonGia(jsonObject.getInt("GiaTong"));
                        getLichSuAdapter.setNgayMua(jsonObject.getString("NgayLap"));
                        getLichSuAdapter.setSoluong(jsonObject.getInt("SoLuong"));

                        getLichSuAdapter.setImgFood(jsonObject.getString("HinhAnh"));

                        lichsuList.add(getLichSuAdapter);

                    }
                }catch (JSONException e) {
                    e.printStackTrace();
                }
                lichSuApdapter = new LichSuApdapter(History.this, lichsuList);
                recyclerView.setAdapter(lichSuApdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(History.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> param = new HashMap<>();
                param.put("MaKH",getId);

                return param;
            }
        };
        requestQueue = Volley.newRequestQueue(History.this);
        requestQueue.add(request);
    }




}