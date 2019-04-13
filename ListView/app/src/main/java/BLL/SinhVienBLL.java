package BLL;

import java.util.ArrayList;

import Entities.SinhVien;

/**
 * Created by nguyendangtinh on 15/10/2017.
 */

public class SinhVienBLL {
    public static ArrayList<SinhVien> getList(){
        ArrayList<SinhVien> ds = new ArrayList<SinhVien>();
        ds.add(new SinhVien("SV01","Nguyễn Minh Trung","Huế","L01"));
        ds.add(new SinhVien("SV02","Lê Thị Ngọc","Quảng Nam","L01"));
        ds.add(new SinhVien("SV03","Trần Hùng","Đà Nẵng","L01"));
        ds.add(new SinhVien("SV04","Lê Hậu","Hà Tĩnh","L02"));
        ds.add(new SinhVien("SV05","Bùi Tiến","Quảng Trị","L02"));
        ds.add(new SinhVien("SV06","Trần Hùng","Đà Nẵng","L02"));
        ds.add(new SinhVien("SV07","Lê Trọng Dũng","Huế","L03"));
        ds.add(new SinhVien("SV08","Lý Thu Hà","Quảng Ngãi","L03"));
        ds.add(new SinhVien("SV09","Đặng Minh Hưng","Nghệ An","L03"));
        ds.add(new SinhVien("SV10","Đinh Trà My","Huế","L04"));
        ds.add(new SinhVien("SV11","Hứa Tuấn","Quảng Nam","L04"));
        ds.add(new SinhVien("SV12","Nguyễn Văn Đoàn","Đà Nẵng","L04"));

        return ds;
    }
    public static SinhVien getSinhVienByIDLop(String maLop){
        ArrayList<SinhVien> csdlSinhVien = getList();
        for(SinhVien sv: csdlSinhVien){
            if (sv.getMaLop().equals(maLop))
                return sv;
        }
        return null;
    }
}
