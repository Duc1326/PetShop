package com.example.ducluu.petshop.views;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ducluu.petshop.App.SessionManager;
import com.example.ducluu.petshop.Helper.ManagementCard;
import com.example.ducluu.petshop.R;
import com.example.ducluu.petshop.databinding.ActivityCaNhanBinding;
import com.example.ducluu.petshop.databinding.ActivityNguoiDungBinding;
import com.example.ducluu.petshop.utils.Utils;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class NguoiDung extends AppCompatActivity {

    ActivityNguoiDungBinding binding;
    String getId;
    private ManagementCard managementCard;
    SessionManager sessionManager;
    Button btn_chinhsuauser,btnlichsumuahang, dangxuat;
    TextView txt_header_ten_user;
    String url = Utils.BASE_URL + "Laptrinhdidong_T7/shopthucung/profile/read_detail.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityNguoiDungBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        sessionManager = new SessionManager(this);
        HashMap<String, String> user = sessionManager.getUserDetail();
        getId = user.get(sessionManager.ID);
        getUserDetail();

        txt_header_ten_user = findViewById(R.id.txt_header_ten_user);

        BottomNavigationView bt  = findViewById(R.id.bottom_navigation);

        bt.setSelectedItemId(R.id.navigation_person);
        bt.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.navigation_home:
                        Intent trangchu = new Intent(NguoiDung.this, TrangChu.class);
                        startActivity(trangchu);
                        break;
                    case R.id.navigation_cart:
                        Intent giohang = new Intent(NguoiDung.this,GioHang.class);
                        startActivity(giohang);
                        break;
                    case R.id.navigation_chat:
                        Intent trochuyen = new Intent(NguoiDung.this,TroChuyen.class);
                        startActivity(trochuyen);
                        break;
                    case R.id.navigation_notifications:
                        Intent thongbao = new Intent(NguoiDung.this,ThongBao.class);
                        startActivity(thongbao);
                        break;
                    case R.id.navigation_person:

                        break;

                }
                return true;
            }
        });
        dangxuat = findViewById(R.id.btn_center_dangxuat_user);
        dangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout = new Intent(NguoiDung.this, DangKy.class);
                startActivity(logout);
            }
        });

        btnlichsumuahang = findViewById(R.id.btn_center_lichsumuahang_user);

        btnlichsumuahang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Lichsu = new Intent(NguoiDung.this, History.class);
                startActivity(Lichsu);
            }
        });

        btn_chinhsuauser = findViewById(R.id.btn_header_chinhsua_user);
        btn_chinhsuauser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NguoiDung.this, CaNhan.class);
                startActivity(intent);
            }
        });
        btnlichsumuahang = findViewById(R.id.btn_center_lichsumuahang_user);
        btnlichsumuahang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NguoiDung.this, History.class);
                startActivity(intent);
            }
        });
    }

    private void getUserDetail() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();


                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("read");

                    if (success.equals("1")) {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            String F_name = object.getString("name").trim();
                            String F_phone = object.getString("phone").trim();
                            String F_ngaysinh = object.getString("dateofbirth");
                            String F_address = object.getString("address").trim();
                            String F_email = object.getString("email").trim();
                            txt_header_ten_user.setText(F_name);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    progressDialog.dismiss();
                    Toast.makeText(NguoiDung.this, "Error" + e.toString(), Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(NguoiDung.this, "Error" + error.toString(), Toast.LENGTH_LONG).show();
            }
        }
        ) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();
                param.put("id", getId);
                return param;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getUserDetail();
    }

}