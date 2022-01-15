package com.example.ducluu.petshop.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ducluu.petshop.Helper.ManagementCardthu;
import com.example.ducluu.petshop.R;
import com.example.ducluu.petshop.model.thucung;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class thucungchoAdapter extends RecyclerView.Adapter<thucungchoAdapter.ViewHolder> {

    Context context;
    ArrayList<thucung> thucungArrayList;
    String gia_format;

    ManagementCardthu managementCardthu;
    private int numberOrder = 1;

    public thucungchoAdapter(Context context, ArrayList<thucung> thucungArrayList) {
        this.context = context;
        this.thucungArrayList = thucungArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_monan, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        Glide.with(context)
                .load(thucungArrayList.get(position).getHinhMon())
                .into(holder.imganh);

        holder.tvName.setText(thucungArrayList.get(position).getTenthu());
        holder.tvStar.setText(String.valueOf(thucungArrayList.get(position).getSoluong()));
        thucungArrayList.get(position).getMota();
        thucungArrayList.get(position).getId();

        gia_format = NumberFormat.getNumberInstance(Locale.US).format(thucungArrayList.get(position).getGiatien());
        holder.tvPrice.setText(gia_format + "đ");



//        holder.btn_add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                thucung object;
//                object = thucungArrayList.get(position);
//                managementCardthu = new ManagementCardthu(context);
//                object.setNumberInCard(numberOrder);
//                managementCardthu.insertFood(object);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return thucungArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imganh;
        TextView tvName, tvPrice, tvStar;
        Button btn_add;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imganh = (ImageView) itemView.findViewById(R.id.imageviewAnh);
            tvName = (TextView) itemView.findViewById(R.id.name);
            tvPrice = (TextView) itemView.findViewById(R.id.gia);
            tvStar = (TextView) itemView.findViewById(R.id.star);
            btn_add = (Button) itemView.findViewById(R.id.btn_add);
        }
    }

    public void filterList(ArrayList<thucung> filteredList) {
        thucungArrayList = filteredList;
        notifyDataSetChanged();
    }
}