package com.example.nguyendangtinh.dubaothoitiet;

/**
 * Created by nguyendangtinh on 15/10/2017.
 */

public class ThoiTiet {
    public String Day;
    public String Status;
    public String Image;
    public String MaxTemp;
    public String MinTemp;

    public ThoiTiet(String day, String status, String image, String maxTemp, String minTemp) {
        Day = day;
        Status = status;
        Image = image;
        MaxTemp = maxTemp;
        MinTemp = minTemp;
    }
}
