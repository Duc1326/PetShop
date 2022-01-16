package com.example.ducluu.petshop.views;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ducluu.petshop.App.MySingleton;
import com.example.ducluu.petshop.App.SessionManager;
import com.example.ducluu.petshop.Helper.ManagementCard;
import com.example.ducluu.petshop.R;
import com.example.ducluu.petshop.databinding.ActivityCaNhanBinding;
import com.example.ducluu.petshop.databinding.ActivitySuaCaNhanBinding;
import com.example.ducluu.petshop.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SuaCaNhan extends AppCompatActivity {

    ImageButton ima_btn_back;
    ActivitySuaCaNhanBinding binding;
    String getId;
    private ManagementCard managementCard;
    SessionManager sessionManager;
    String url = Utils.BASE_URL + "Laptrinhdidong_T7/shopthucung/profile/read_detail.php";
    EditText tenkh,emailkh,sdtkh,ngaysinhkh,diachikh;
    Button btnsua;
    String url_edit = Utils.BASE_URL + "Laptrinhdidong_T7/shopthucung/profile/edit_detail.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySuaCaNhanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AnhXa();
        sessionManager = new SessionManager(this);
        HashMap<String, String> user = sessionManager.getUserDetail();
        getId = user.get(sessionManager.ID);
        getUserDetail();
        ima_btn_back = findViewById(R.id.image_btn_back_canhan);

        ima_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SuaCaNhan.this, CaNhan.class);
                startActivity(intent);

            }
        });

        btnsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveEditDetail();
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

                            tenkh.setText(F_name);
                            sdtkh.setText(F_phone);
                            diachikh.setText(F_address);
                            ngaysinhkh.setText(F_ngaysinh);
                            emailkh.setText(F_email);

                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    progressDialog.dismiss();
                    Toast.makeText(SuaCaNhan.this, "Error" + e.toString(), Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(SuaCaNhan.this, "Error" + error.toString(), Toast.LENGTH_LONG).show();
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
    private void SaveEditDetail() {
        final String name = this.tenkh.getText().toString().trim();
        final String email = this.emailkh.getText().toString().trim();
        final String id = getId;
        final String birth = this.ngaysinhkh.getText().toString().trim();
        final String phone = this.sdtkh.getText().toString().trim();
        final String adress = this.diachikh.getText().toString().trim();

        final ProgressDialog progressDialog = new ProgressDialog(SuaCaNhan.this);
        progressDialog.setTitle("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(false);
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_edit,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");

                            if(success.equals("1")){
                                Toast.makeText(SuaCaNhan.this, "Update Thành công", Toast.LENGTH_SHORT).show();
                                sessionManager.createSession(name,email,phone,birth,id);
                                Intent intent = new Intent(SuaCaNhan.this, CaNhan.class);
                                startActivity(intent);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            progressDialog.dismiss();
                            Toast.makeText(SuaCaNhan.this, "Error" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(SuaCaNhan.this, "Error" + error.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("name",name);
                params.put("email",email);
                params.put("phone",phone);
                params.put("dateofbirth",birth);
                params.put("adress",adress);
                params.put("id",id);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    public void AnhXa(){
        tenkh= (EditText) findViewById(R.id.ed_ten);
        emailkh = (EditText) findViewById(R.id.ed_email);
        sdtkh =(EditText) findViewById(R.id.ed_sdt);
        ngaysinhkh=(EditText) findViewById(R.id.ed_ngaysinh);
        diachikh=(EditText) findViewById(R.id.ed_diachi);
        btnsua= (Button) findViewById(R.id.btn_sua);
    }
}

