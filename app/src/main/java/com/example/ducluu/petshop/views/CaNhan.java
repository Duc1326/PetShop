package com.example.ducluu.petshop.views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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
import com.example.ducluu.petshop.databinding.ActivityMyOrderBinding;
import com.example.ducluu.petshop.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CaNhan extends AppCompatActivity {
    ImageButton ima_btn_back;
    ActivityCaNhanBinding binding;
    String getId;
    private ManagementCard managementCard;
    SessionManager sessionManager;
    String url = Utils.BASE_URL + "/shopthucung/profile/read_detail.php";
    TextView tenkh,emailkh,sdtkh,ngaysinhkh,diachikh;
    Button btnsua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCaNhanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        sessionManager = new SessionManager(this);
        HashMap<String, String> user = sessionManager.getUserDetail();
        getId = user.get(sessionManager.ID);
        getUserDetail();
        ima_btn_back = findViewById(R.id.image_btn_back_canhan);

//        ima_btn_back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(CaNhan.this, NguoiDung.class);
//                startActivity(intent);
//
//            }
//        });
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
                            String F_address = object.getString("address").trim();
                            String F_addressSpecific = object.getString("addressSpecific").trim();

                            tenkh.setText(F_name);
                            sdtkh.setText(" _ " + F_phone);
                            diachikh.setText(F_address);
                            emailkh.setText(F_addressSpecific);

                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    progressDialog.dismiss();
                    Toast.makeText(CaNhan.this, "Error" + e.toString(), Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(CaNhan.this, "Error" + error.toString(), Toast.LENGTH_LONG).show();
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
    public void AnhXa(){
        tenkh= (TextView) findViewById(R.id.tenkh);
        emailkh = (TextView) findViewById(R.id.email);
        sdtkh =(TextView) findViewById(R.id.sdt);
        ngaysinhkh=(TextView) findViewById(R.id.ngaysinh);
        diachikh=(TextView) findViewById(R.id.diachi);
        btnsua= (Button) findViewById(R.id.btn_sua);
    }



}