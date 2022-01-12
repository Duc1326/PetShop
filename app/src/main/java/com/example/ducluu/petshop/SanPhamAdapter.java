package com.example.ducluu.petshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SanPhamAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<spSanPham> spSanPhamList;

    public SanPhamAdapter(Context context, int layout, List<spSanPham> spSanPhamList) {
        this.context = context;
        this.layout = layout;
        this.spSanPhamList = spSanPhamList;
    }

    @Override
    public int getCount() {
        return spSanPhamList.size();
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
        TextView txtTen= (TextView) view.findViewById(R.id.texttensp);
        TextView txtGia = (TextView) view.findViewById(R.id.txtgiasp);
        TextView txtMota =(TextView) view.findViewById(R.id.textmota);
        TextView txtXem =(TextView) view.findViewById(R.id.txtxem);
        ImageView imgHinh = (ImageView) view.findViewById(R.id.imHinhsp);

        spSanPham sp =spSanPhamList.get(i);
        txtTen.setText(sp.getTen());
        txtGia.setText(sp.getGia());
        txtMota.setText(sp.getMota());
        txtXem.setText("Xem chi tiết");
        imgHinh.setImageResource(sp.getHinh());
        return view;
    }
}
