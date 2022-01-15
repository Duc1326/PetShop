package com.example.ducluu.petshop.views;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.ducluu.petshop.App.MySingleton;
import com.example.ducluu.petshop.R;
import com.example.ducluu.petshop.utils.Utils;

import java.util.HashMap;
import java.util.Map;

public class DangKy extends AppCompatActivity {
    Button btn_dangky;
    EditText sdt, pass, pass2;
    ImageButton btn_back;
    String Name,Email,Pass,PassConf;
    String url = Utils.BASE_URL + "Laptrinhdidong_T7/shopthucung/canhan/dangki.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);


        anhxa();
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(DangKy.this, Dangnhap_Dangki.class);
                startActivity(back);
            }
        });

        btn_dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Name = sdt.getText().toString();
                Pass = pass.getText().toString();
                PassConf = pass2.getText().toString();
                if(TextUtils.isEmpty(Name) || TextUtils.isEmpty(PassConf) || TextUtils.isEmpty(Pass)
                        || TextUtils.isEmpty(PassConf)){
                    Toast.makeText(DangKy.this, "Vui lòng nhập đủ thông tin!", Toast.LENGTH_SHORT).show();
                }else{
                    if (Pass.equals(PassConf) == false){
                        Toast.makeText(DangKy.this, "Các mật khẩu đã nhập không khớp.Hãy thử lại!", Toast.LENGTH_SHORT).show();
                    }else{
                            registerNewAccount(Name,Pass);
                    }
                }

            }
        });

    }




    public void anhxa(){
        btn_dangky = findViewById(R.id.btn_center_login_dangky);
        sdt = findViewById(R.id.edit_center_user_dangky);
        pass = findViewById(R.id.edit_center_password_dangky);
        pass2 = findViewById(R.id.edit_center_fogetpassword_dangky);
        btn_back = findViewById(R.id.image_back_dangky);
    }

    private void registerNewAccount(final String username,final String password){
        final ProgressDialog progressDialog = new ProgressDialog(DangKy.this);
        progressDialog.setTitle("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setIndeterminate(false);
        progressDialog.show();
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if(response.equals("")){

                    startActivity(new Intent(DangKy.this,DangNhap.class));
                    progressDialog.dismiss();

                }else{
                    progressDialog.dismiss();
                    Toast.makeText(DangKy.this, response, Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(DangKy.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> param = new HashMap<>();
                param.put("sdt",Name);
                param.put("psw",password);

                return param;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(3000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MySingleton.getmInstance(DangKy.this).addToRequestQueue(request);
    }

}