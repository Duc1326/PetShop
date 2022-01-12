package com.example.ducluu.petshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GioHangAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<spGioHang> spGioHangList;

    public GioHangAdapter(Context context, int layout, List<spGioHang> spGioHangList) {
        this.context = context;
        this.layout = layout;
        this.spGioHangList = spGioHangList;
    }

    @Override
    public int getCount() {
        return spGioHangList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view =inflater.inflate(layout,null);

        //ánh xạ view
        TextView txtTen= (TextView) view.findViewById(R.id.textten);
        TextView txtGia = (TextView) view.findViewById(R.id.textgia);
        ImageView imgHinh = (ImageView) view.findViewById(R.id.imHinh);

        spGioHang sp =spGioHangList.get(i);
        txtTen.setText(sp.getTen());
        txtGia.setText(sp.getGia());
        imgHinh.setImageResource(sp.getHinh());
        return view;
    }
}
