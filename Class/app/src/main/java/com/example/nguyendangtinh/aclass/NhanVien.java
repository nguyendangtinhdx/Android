package com.example.nguyendangtinh.aclass;

/**
 * Created by nguyendangtinh on 30/09/2017.
 */

public class NhanVien {
//    public  String HoTen;
//    public Integer NamSinh;
//    public Integer Tuoi;
//
//    public NhanVien(String hoTen, Integer namSinh) {
//        HoTen = hoTen;
//        NamSinh = namSinh;
//        Tuoi = 2017 - namSinh;
//    }
    private Integer NamSinh;

    public void setNamSinh(Integer namSinh) {
        if (namSinh > 1990)
            NamSinh = namSinh;
        else
            NamSinh = 1990;
    }

    public Integer getNamSinh() {
        return NamSinh;
    }
}
