package com.example.ducluu.petshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.util.List;

public class AnhvaoAdapter extends PagerAdapter {

    private Context lcontext;
    private List<Anhvao> llistAnhvao;


    public AnhvaoAdapter(Context lcontext, List<Anhvao> llistAnhvao) {
        this.lcontext = lcontext;
        this.llistAnhvao = llistAnhvao;
    }

    @Override
    public int getCount() {
        if (llistAnhvao != null)
        {
            return llistAnhvao.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view =  LayoutInflater.from(container.getContext()).inflate(R.layout.list_dangnhap_dangki, container, false);

        ImageView imgAnhvao = view.findViewById(R.id.img_anh_dang_nhap);

        Anhvao anhvao = llistAnhvao.get(position);

        if (anhvao != null){
            Glide.with(lcontext).load(anhvao.getResourceid()).into(imgAnhvao);

        }

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View) object);
    }

}
