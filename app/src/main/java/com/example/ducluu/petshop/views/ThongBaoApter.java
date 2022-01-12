package com.example.ducluu.petshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ThongBaoApter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<spThongBao> ThongBaoList;

    public ThongBaoApter(Context context, int layout, List<spThongBao> ThongBaoList) {
        this.context = context;
        this.layout = layout;
        this.ThongBaoList = ThongBaoList;
    }

    @Override
    public int getCount() {
        return ThongBaoList.size();
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
        TextView txtmota=(TextView) view.findViewById(R.id.textmota);
        ImageView imgHinh = (ImageView) view.findViewById(R.id.imHinh);

        spThongBao sp =ThongBaoList.get(i);
        txtmota.setText(sp.getMota());
        imgHinh.setImageResource(sp.getHinh());
        return view;
    }
}
