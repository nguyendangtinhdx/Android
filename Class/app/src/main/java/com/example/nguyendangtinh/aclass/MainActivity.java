package com.example.nguyendangtinh.aclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        NhanVien Tinh = new NhanVien("Nguyễn Đăng Tỉnh",1996);
//        String s = Tinh.HoTen + " " + Tinh.NamSinh.toString() + " " + Tinh.Tuoi.toString();
//
//        Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();

        NhanVien Binh = new NhanVien();
        Binh.setNamSinh(1880);
        Toast.makeText(MainActivity.this,"" + Binh.getNamSinh(),Toast.LENGTH_LONG).show();
    }
}
