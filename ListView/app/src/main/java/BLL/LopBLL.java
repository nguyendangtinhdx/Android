package BLL;

import java.util.ArrayList;

import Entities.Lop;

public class LopBLL {
    // lấy all danh sách có trong db
    public static ArrayList<Lop> getList(){
        ArrayList<Lop> ls = new ArrayList<Lop>();
        ls.add(new Lop("L01","TinK38A","Lê Thanh",24,"GV01"));
        ls.add(new Lop("L02","TinK38B","Trần Huy",54,"GV02"));
        ls.add(new Lop("L03","TinK38C","Nguyễn Tiến",36,"GV03"));
        ls.add(new Lop("L04","TinK38D","Lưu Lan",45,"GV04"));
//        ls.add(new Lop("5","TinK38E","Đoàn Công Hùng",40));
//        ls.add(new Lop("6","TinK38F","Nguyễn Văn Hưng",29));
//        ls.add(new Lop("7","TinK38G","Lê Thanh Hiệp",62));
        return ls;

    }
}
