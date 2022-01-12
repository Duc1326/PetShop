package com.example.ducluu.petshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class SanPham extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_pham);
        BottomNavigationView bt  = findViewById(R.id.bottom_navigation);

        bt.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.navigation_home:
                        Intent trangchu = new Intent(SanPham.this, TrangChu.class);
                        startActivity(trangchu);
                        break;
                    case R.id.navigation_cart:
                        Intent giohang = new Intent(SanPham.this,GioHang.class);
                        startActivity(giohang);
                        break;
                    case R.id.navigation_chat:
                        Intent trochuyen = new Intent(SanPham.this,TroChuyen.class);
                        startActivity(trochuyen);
                        break;
                    case R.id.navigation_notifications:
                        Intent thongbao = new Intent(SanPham.this,ThongBao.class);
                        startActivity(thongbao);
                        break;
                    case R.id.navigation_person:
                        Intent canhan = new Intent(SanPham.this,NguoiDung.class);
                        startActivity(canhan);
                        break;

                }
                return true;
            }
        });

        Intent intent = getIntent();
        Integer id = intent.getIntExtra("dulieu",1);

        switch (id){
            case 1:
                button = findViewById(R.id.btn);
                anhxacho();
                break;
            case 2:
                button = findViewById(R.id.btn1);
                anhxameo();
                break;
            case 3:
                button = findViewById(R.id.btn2);
                anhxachim();
                break;
            case 4:
                button = findViewById(R.id.btn3);
                anhxaca();
                break;
            default:
                button = findViewById(R.id.btn);
                anhxacho();
                break;
        }

        adapter = new SanPhamAdapter(this,R.layout.dong_sanpham,arraySP);
        lviewSanPham.setAdapter(null);
        lviewSanPham.setAdapter(adapter);
        button.setBackground(Drawable.createFromPath("#FE9D9D"));
    }
    Button button;
    ListView lviewSanPham;
    ArrayList<spSanPham> arraySP;
    SanPhamAdapter adapter;

    public void onClick(View v) {

        Drawable dr = getResources().getDrawable(R.drawable.button_pressed);
        dr.setColorFilter(Color.parseColor("#FE9D9D"), PorterDuff.Mode.SRC_ATOP);

        switch (v.getId()) {
            case R.id.btn:

                if (button == null) {
                    button = (Button) findViewById(v.getId());

                } else {
                    button.setBackgroundResource(R.drawable.button_pressed);
                    button = (Button) findViewById(v.getId());
                    anhxacho();
                    adapter = new SanPhamAdapter(this,R.layout.dong_sanpham,arraySP);
                    lviewSanPham.setAdapter(null);
                    lviewSanPham.setAdapter(adapter);
                }
                button.setBackgroundDrawable(dr);

                break;

            case R.id.btn1:
                if (button == null) {
                    button = (Button) findViewById(v.getId());

                } else {
                    button.setBackgroundResource(R.drawable.button_pressed);
                    button = (Button) findViewById(v.getId());
                    anhxameo();
                    adapter = new SanPhamAdapter(this,R.layout.dong_sanpham,arraySP);
                    lviewSanPham.setAdapter(null);
                    lviewSanPham.setAdapter(adapter);
                }
                button.setBackgroundDrawable(dr);

                break;
            case R.id.btn2:
                if (button == null) {
                    button = (Button) findViewById(v.getId());
                } else {
                    button.setBackgroundResource(R.drawable.button_pressed);
                    button = (Button) findViewById(v.getId());
                    anhxachim();
                    adapter = new SanPhamAdapter(this,R.layout.dong_sanpham,arraySP);
                    lviewSanPham.setAdapter(null);
                    lviewSanPham.setAdapter(adapter);
                }
                button.setBackgroundDrawable(dr);

                break;
            case R.id.btn3:
                if (button == null) {
                    button = (Button) findViewById(v.getId());
                } else {
                    button.setBackgroundResource(R.drawable.button_pressed);
                    button = (Button) findViewById(v.getId());
                    anhxaca();
                    adapter = new SanPhamAdapter(this,R.layout.dong_sanpham,arraySP);
                    lviewSanPham.setAdapter(null);
                    lviewSanPham.setAdapter(adapter);
                }
                button.setBackgroundDrawable(dr);

                break;
            case R.id.txtxem:
                Intent chitiet = new Intent(SanPham.this, ThongTinsp.class);
                startActivity(chitiet);
                break;
            case R.id.btgio:
                Intent giohang = new Intent(SanPham.this, GioHang.class);
                startActivity(giohang);
                break;
            case R.id.btmuan:
                Intent thanhtoan = new Intent(SanPham.this, ThanhToan.class);
                startActivity(thanhtoan);
                break;

            default:
                break;
        }
    }
    private void anhxacho() {
        lviewSanPham = (ListView) findViewById(R.id.lvSanPham);
        arraySP = new ArrayList<>();

        arraySP.add(new spSanPham("Chó lông xù đáng yêu","đ3.400.000","Chó lông xù nhập khẩu anh",R.drawable.cho1));
        arraySP.add(new spSanPham("Chó mặt xệ","đ8.400.000","Loại chó có chân ngắn",R.drawable.chopug));
        arraySP.add(new spSanPham("Chó alaska","đ2.400.000","Chó alaska bắt nguồn từ loài sói lai chó nhà",R.drawable.choalaska));
        arraySP.add(new spSanPham("Chó becgie","đ1.200.000","Chó nhập khẩu anh",R.drawable.chobecgie));

    }
    private  void  anhxameo(){
        lviewSanPham = (ListView) findViewById(R.id.lvSanPham);
        arraySP = new ArrayList<>();

        arraySP.add(new spSanPham("Mèo anh lông ngắn","đ1.200.000","Chó lông xù nhập khẩu anh",R.drawable.meoaln));
        arraySP.add(new spSanPham("Mèo anh lông dài","đ3.200.000","Chó lông xù nhập khẩu anh",R.drawable.meoald));
        arraySP.add(new spSanPham("Mèo ba tư","đ1.000.000","Chó lông xù nhập khẩu anh",R.drawable.meobatu));

    }
    private  void  anhxachim(){
        lviewSanPham = (ListView) findViewById(R.id.lvSanPham);
        arraySP = new ArrayList<>();

        arraySP.add(new spSanPham("Chim ưng","đ1.200.000","Đại bàng vỗ cánh,siêu nhân vàng",R.drawable.chimung));
        arraySP.add(new spSanPham("Sáo đã biết nói","đ2.200.000","Chim sao hai tháng tuổi đã biêt nói",R.drawable.chimsao));
        arraySP.add(new spSanPham("Chim sâu","đ500.000","Chim sâu tiếng hót nghe thanh",R.drawable.chimchaomao));
        arraySP.add(new spSanPham("Chim vàng khuyên","đ600.000","Chim 1 năm tuổi khỏe mạnh",R.drawable.chimvanhkhuyen));
        arraySP.add(new spSanPham("Cú mèo","đ1.000.000","Cú mèo hoang dã, cực to",R.drawable.chimcumeo));
        arraySP.add(new spSanPham("Chim chào mào","đ1.000.000","Mìu có tiếng hót nghe rất hay,êm tai",R.drawable.chimchaomao));
    }
    private  void  anhxaca(){
        lviewSanPham = (ListView) findViewById(R.id.lvSanPham);
        arraySP = new ArrayList<>();

        arraySP.add(new spSanPham("Cá coi","đ200.000","Cá coi màu sắc cực đa dạng, có bán lẻ",R.drawable.cacoi));
        arraySP.add(new spSanPham("Cá đầu lân","đ50.000","Loại cá phù hợp nuôi làm thú vui",R.drawable.cadaulan));

    }


}