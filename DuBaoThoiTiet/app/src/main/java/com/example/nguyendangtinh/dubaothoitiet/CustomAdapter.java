package com.example.nguyendangtinh.dubaothoitiet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by nguyendangtinh on 15/10/2017.
 */

public class CustomAdapter extends BaseAdapter{
    Context context;
    ArrayList<ThoiTiet> arrayList;

    public CustomAdapter(Context context, ArrayList<ThoiTiet> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.dong_listview,null);

        ThoiTiet thoiTiet = arrayList.get(i);
        TextView txtDay = (TextView) view.findViewById(R.id.textviewNgay);
        TextView txtStatus = (TextView) view.findViewById(R.id.textviewTrangThai);
        TextView txtMaxTemp = (TextView) view.findViewById(R.id.textviewMaxTemp);
        TextView txtMinTemp =  (TextView) view.findViewById(R.id.textviewMinTemp);
        ImageView imgStatus = (ImageView) view.findViewById(R.id.imageviewTrangThai);

        txtDay.setText(thoiTiet.Day);
        txtStatus.setText(thoiTiet.Status);
        txtMaxTemp.setText(thoiTiet.MaxTemp + " ºC");
        txtMinTemp.setText(thoiTiet.MinTemp + " ºC");

        Picasso.with(context).load("http://openweathermap.org/img/w/"+thoiTiet.Image+".png").into(imgStatus); // load icon

        return view;
    }
}
