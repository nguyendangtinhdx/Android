package Entities;

public class Lop {
    private String maLop;
    private String tenLop;
    private String tenGiaoVienCoVan;
    private int siSo;
    private String maGiangVien;

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getTenGiaoVienCoVan() {
        return tenGiaoVienCoVan;
    }

    public void setTenGiaoVienCoVan(String tenGiaoVienCoVan) {
        this.tenGiaoVienCoVan = tenGiaoVienCoVan;
    }

    public int getSiSo() {
        return siSo;
    }

    public void setSiSo(int siSo) {
        this.siSo = siSo;
    }

    public String getMaGiangVien() {
        return maGiangVien;
    }

    public void setMaGiangVien(String maGiangVien) {
        this.maGiangVien = maGiangVien;
    }

    public Lop(String maLop, String tenLop, String tenGiaoVienCoVan, int siSo, String maGiangVien) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.tenGiaoVienCoVan = tenGiaoVienCoVan;
        this.siSo = siSo;
        this.maGiangVien = maGiangVien;
    }
}
