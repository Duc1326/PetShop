package com.example.ducluu.petshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class TrangChu extends AppCompatActivity {
    Button btnsanpham,btnthucan,btnthuoc,btnsukien,btnphukien;
    ImageButton btn_cho,btn_chim,btn_meo,btn_ca;
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private PhotoAdapter photoAdapter;
    private List<Photo> mlistphoto;
    private Timer mtimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);

        btn_chim = findViewById(R.id.imagebtn_seacher_bird_trangchu);
        btn_cho = findViewById(R.id.imagebtn_seacherdog_tramhchu);
        btn_meo = findViewById(R.id.imagebtn_seachercat_trangchu);
        btn_ca = findViewById(R.id.imgagebtn_seacher_fish_trangchu);

        btnsanpham = findViewById(R.id.btn_sanpham_trangchu);
        btnphukien = findViewById(R.id.btn_phukieen_trangchu);
        btnthucan = findViewById(R.id.btn_thucan_trangchu);
        btnthuoc = findViewById(R.id.btn_thuoc_trangchu);

        BottomNavigationView bt  = findViewById(R.id.bottom_navigation);

        bt.setSelectedItemId(R.id.navigation_home);
        bt.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.navigation_home:

                        break;
                    case R.id.navigation_cart:
                        Intent giohang = new Intent(TrangChu.this,GioHang.class);
                        startActivity(giohang);
                        break;
                    case R.id.navigation_chat:
                        Intent trochuyen = new Intent(TrangChu.this,TroChuyen.class);
                        startActivity(trochuyen);
                        break;
                    case R.id.navigation_notifications:
                        Intent thongbao = new Intent(TrangChu.this,ThongBao.class);
                        startActivity(thongbao);
                        break;
                    case R.id.navigation_person:
                        Intent canhan = new Intent(TrangChu.this,NguoiDung.class);
                        startActivity(canhan);
                        break;

                }

                return true;
            }
        });

        btnsanpham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sanpham = new Intent(TrangChu.this, SanPham.class);
                sanpham.putExtra("dulieu",1);
                startActivity(sanpham);
            }
        });

        btnphukien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phukien = new Intent(TrangChu.this, PhuKien1.class);
                startActivity(phukien);
            }
        });

        btnthucan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent thucan = new Intent(TrangChu.this, ThucAn.class);
                startActivity(thucan);
            }
        });

        btnthuoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent thuoc = new Intent(TrangChu.this, ThuocThuY.class);
                startActivity(thuoc);
            }
        });

        btn_cho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sanpham1 = new Intent(TrangChu.this, SanPham.class);
                sanpham1.putExtra("dulieu",1);
                startActivity(sanpham1);
            }
        });

        btn_ca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sanpham1 = new Intent(TrangChu.this, SanPham.class);
                sanpham1.putExtra("dulieu",4);
                startActivity(sanpham1);
            }
        });
        btn_chim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sanpham1 = new Intent(TrangChu.this, SanPham.class);
                sanpham1.putExtra("dulieu",3);
                startActivity(sanpham1);
            }
        });
        btn_meo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sanpham1 = new Intent(TrangChu.this, SanPham.class);
                sanpham1.putExtra("dulieu",2);
                startActivity(sanpham1);
            }
        });




        circleIndicator = findViewById(R.id.circle_indicator);
        viewPager = findViewById(R.id.viewpager);

        mlistphoto = getListPhoto();
        photoAdapter = new PhotoAdapter(this,mlistphoto);
        viewPager .setAdapter(photoAdapter);
        circleIndicator.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
        autoSlineImage();

    }
    private List<Photo> getListPhoto(){
        List<Photo> list = new ArrayList<>();
        list.add(new Photo(R.drawable.anhqc01));
        list.add(new Photo(R.drawable.anhqc02));
        list.add(new Photo(R.drawable.anhqc03));
        list.add(new Photo(R.drawable.anhqc04));
        return list;
    }

    private void autoSlineImage(){
        if (mlistphoto == null || mlistphoto.isEmpty()){
            return ;
        }
        if (mtimer == null){
            mtimer = new Timer();
        }
        mtimer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = viewPager.getCurrentItem();
                        int totalItem = mlistphoto.size()-1;
                        if(currentItem == totalItem){
                            viewPager.setCurrentItem(0);

                        }
                        else {
                            currentItem ++;
                            viewPager.setCurrentItem(currentItem);
                        }

                    }
                });
            }
        },500, 3000);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mtimer != null) {
            mtimer.cancel();
            mtimer = null;
        }
    }


}