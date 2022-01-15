package com.example.ducluu.petshop.adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.example.ducluu.petshop.Helper.ManagementCard;
import com.example.ducluu.petshop.Helper.ManagementCardthu;
import com.example.ducluu.petshop.model.MonAn;
import com.example.ducluu.petshop.R;
import com.example.ducluu.petshop.views.ShowDetail;
import com.example.ducluu.petshop.views.ThongTinsp;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MonAnListAdapter extends RecyclerView.Adapter<MonAnListAdapter.ViewHolder> {

    Context context;
    ArrayList<MonAn> monAnList;
    String gia_format;

    ManagementCard managementCard;
    private int numberOrder = 1;

    public MonAnListAdapter(Context context, ArrayList<MonAn> monAnList) {
        this.context = context;
        this.monAnList = monAnList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_monan, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    public void clearApplications() {
        int size = this.monAnList.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                monAnList.remove(0);
            }

            this.notifyItemRangeRemoved(0, size);
        }
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        Glide.with(context)
                .load(monAnList.get(position).getHinhMon())
                .into(holder.imgFood);

        holder.tvName.setText(monAnList.get(position).getTenMon());
        holder.tvStar.setText(String.valueOf(monAnList.get(position).getSao()));
        monAnList.get(position).getMoTa();
        monAnList.get(position).getMaSP();

        gia_format = NumberFormat.getNumberInstance(Locale.US).format(monAnList.get(position).getGia());
        holder.tvPrice.setText(gia_format + "đ");


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ThongTinsp.class);
                intent.putExtra("detail", monAnList.get(position));
                context.startActivity(intent);
            }
        });

        holder.btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MonAn object;
                object = monAnList.get(position);
                managementCard = new ManagementCard(context);
                object.setNumberInCard(numberOrder);
                managementCard.insertFood(object);

            }
        });
    }

    @Override
    public int getItemCount() {
        return monAnList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgFood;
        TextView tvName, tvPrice, tvStar;
        Button btn_add;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood = (ImageView) itemView.findViewById(R.id.imageviewAnh);
            tvName = (TextView) itemView.findViewById(R.id.name);
            tvPrice = (TextView) itemView.findViewById(R.id.gia);
            tvStar = (TextView) itemView.findViewById(R.id.star);
            btn_add = (Button) itemView.findViewById(R.id.btn_add);
        }
    }

    public void filterList(ArrayList<MonAn> filteredList) {
        monAnList = filteredList;
        notifyDataSetChanged();
    }
}