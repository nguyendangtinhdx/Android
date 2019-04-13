package BLL;


import java.util.ArrayList;

import Entities.GiangVien;

public class GiangVienBLL {
    /**
     * Lấy toàn bộ danh sách giảng viên có trong CSDL
     * @return danh sách giảng viên
     */
    public static ArrayList<GiangVien> getList(){
        ArrayList<GiangVien> rs = new ArrayList<GiangVien>();
        rs.add(new GiangVien("GV01","Lê Thanh","3/4/1987","Huế",true));
        rs.add(new GiangVien("GV02","Trần Huy","13/7/1984","Quảng Nam",true));
        rs.add(new GiangVien("GV03","Nguyễn Tiến","30/12/1981","Quảng Bình",true));
        rs.add(new GiangVien("GV04","Lưu Lan","1/2/1980","Đà Nẵng",false));

        return rs;
    }

    /**
     * Lấy giảng viên trong csdl theo mã giảng viên
     * @param maGiangVien
     * @return giảng viên được tìm thấy, = null nếu không tìm thấy
     */
    public static GiangVien getByID(String maGiangVien){
        ArrayList<GiangVien> csdlGiangVien = getList();
        for (GiangVien gv:csdlGiangVien) {
            if(gv.getMaGiangVien().equals(maGiangVien))
                return gv;
        }
        return null;
    }
}
