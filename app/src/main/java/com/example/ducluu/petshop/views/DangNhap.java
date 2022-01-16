package com.example.ducluu.petshop.views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ducluu.petshop.App.SessionManager;
import com.example.ducluu.petshop.R;
import com.example.ducluu.petshop.model.account;
import com.example.ducluu.petshop.utils.Utils;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DangNhap extends AppCompatActivity {
    Button btn_login;
    ImageButton btn_back;
    TextView  foget_pass;
    String username, password;
    EditText user, pass;
    SessionManager sessionManager;
    SharedPreferences sharedPreferences;
    String url = Utils.BASE_URL + "ltdd/shopthucung/canhan/account.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        sharedPreferences = getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        sessionManager= new SessionManager(this);

        AnhXa();


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username=user.getText().toString().trim();
                password=pass.getText().toString().trim();
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
                    Toast.makeText(DangNhap.this, "Vui lòng nhập đủ thông tin!", Toast.LENGTH_SHORT).show();
                }else
                    logIn(username,password);
            }
        });


    }

    public void logIn(final String sdt,final String password) {
        final ProgressDialog progressDialog = new ProgressDialog(DangNhap.this);
        progressDialog.setTitle("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(false);
        progressDialog.show();
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("login");
                    if (success.equals("1")){
                        for(int i= 0;i<jsonArray.length();i++){
                            JSONObject object = jsonArray.getJSONObject(i);
                            String name = object.getString("name").trim();
                            String email = object.getString("email").trim();
                            String phone = object.getString("phone").trim();
                            String dateofbirth = object.getString("dateofbirth").trim();

                            String address = object.getString("address").trim();
                            String addressSpecific = object.getString("addressSpecific").trim();
                            String id = object.getString("id").trim();
                            Utils.getId  = object.getString("id").trim();

                            sessionManager.createSession(name,email,phone,dateofbirth,id);
                            sessionManager.createSession2(name,phone,address,addressSpecific,id);
                            progressDialog.dismiss();
                            Toast.makeText(DangNhap.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                            Intent trangchu = new Intent(DangNhap.this, TrangChu.class);
                            startActivity(trangchu);
                        }
                    }else{
                        progressDialog.dismiss();
                        Toast.makeText(DangNhap.this, "SDT hoặc mật khẩu không đúng!", Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    progressDialog.dismiss();
                    Toast.makeText(DangNhap.this, "SDT hoặc mật khẩu không đúng!", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(DangNhap.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> param = new HashMap<>();
                param.put("email",sdt);
                param.put("psw",password);
                return param;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }


    public void AnhXa() {
        foget_pass = findViewById(R.id.foget_pass);
        btn_login = findViewById(R.id.btn_center_login_dangnhap);
        user = findViewById(R.id.edit_center_user_dangnhap);
        pass = findViewById(R.id.edit_center_password_dangnhap);
    }
}
