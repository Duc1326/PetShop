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

public class PhotoAdapter extends PagerAdapter {

    private Context mcontext;
    private List<Photo> mlistphoto;

    public PhotoAdapter(Context mcontext, List<Photo> mlistphoto) {
        this.mcontext = mcontext;
        this.mlistphoto = mlistphoto;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view =  LayoutInflater.from(container.getContext()).inflate(R.layout.item_photo, container, false);

        ImageView imgphoto = view.findViewById(R.id.img_photo);

        Photo photo = mlistphoto.get(position);

        if (photo != null){
            Glide.with(mcontext).load(photo.getResourceid()).into(imgphoto);

        }

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        if (mlistphoto != null)
        {
            return mlistphoto.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
