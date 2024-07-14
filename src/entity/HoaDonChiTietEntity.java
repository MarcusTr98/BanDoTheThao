package entity;

public class HoaDonChiTietEntity {

    private int MaHDCT;
    private String maHDBan;
    private String maSP;
    private int soLuong;
    private float giamGia;
    private float thanhTien;

    public HoaDonChiTietEntity(int MaHDCT, String maHDBan, String maSP, int soLuong, float giamGia, float thanhTien) {
        this.MaHDCT = MaHDCT;
        this.maHDBan = maHDBan;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.giamGia = giamGia;
        this.thanhTien = thanhTien;
    }

    public HoaDonChiTietEntity() {
    }

    public int getMaHDCT() {
        return MaHDCT;
    }

    public void setMaHDCT(int MaHDCT) {
        this.MaHDCT = MaHDCT;
    }

    public String getMaHDBan() {
        return maHDBan;
    }

    public void setMaHDBan(String maHDBan) {
        this.maHDBan = maHDBan;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(float giamGia) {
        this.giamGia = giamGia;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    
}
