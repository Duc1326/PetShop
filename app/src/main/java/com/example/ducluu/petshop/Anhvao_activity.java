package com.example.ducluu.petshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class Anhvao_activity extends AppCompatActivity {

    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private AnhvaoAdapter anhvaoAdapter;
    private List<Anhvao> llistanhvao;
    private Timer mtimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anhvao);

        circleIndicator = findViewById(R.id.circle_indicator);
        viewPager = findViewById(R.id.viewpager);

        llistanhvao = getListAnhvao();
        anhvaoAdapter = new AnhvaoAdapter(this, llistanhvao);
        viewPager.setAdapter(anhvaoAdapter);

        circleIndicator.setViewPager(viewPager);
        anhvaoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
        autoSlineImage();

    }

    private List<Anhvao> getListAnhvao() {
        List<Anhvao> list = new ArrayList<>();
        list.add(new Anhvao(R.drawable.list_view_vao_1));
        list.add(new Anhvao(R.drawable.list_view_vao_2));
        return list;
    }

    private void autoSlineImage() {
        if (llistanhvao == null || llistanhvao.isEmpty()) {
            return;
        }

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int currentItem = viewPager.getCurrentItem();
                int totalItem = llistanhvao.size()-1;
                while (currentItem < totalItem) {
                    currentItem++;
                    viewPager.setCurrentItem(currentItem);
                }
            }
        }, 3000);

        final Handler handler1 = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent dnsk = new Intent(Anhvao_activity.this, Dangnhap_Dangki.class);
                startActivity(dnsk);
            }
        }, 6000);

    }
}