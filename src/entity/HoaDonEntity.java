package entity;

import java.util.Date;

public class HoaDonEntity {

    private String maHDBan;
    private int maNV;
    private Date ngayBan;
    private int maKH;
    private boolean tinhTrang_ThanhToan;

    public HoaDonEntity(String maHDBan, int maNV, Date ngayBan, int maKH, boolean tinhTrang_ThanhToan) {
        this.maHDBan = maHDBan;
        this.maNV = maNV;
        this.ngayBan = ngayBan;
        this.maKH = maKH;
        this.tinhTrang_ThanhToan = tinhTrang_ThanhToan;
    }
    
 public HoaDonEntity(){
     
 }

    public String getMaHDBan() {
        return maHDBan;
    }

    public void setMaHDBan(String maHDBan) {
        this.maHDBan = maHDBan;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public Date getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(Date ngayBan) {
        this.ngayBan = ngayBan;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public boolean isTinhTrang_ThanhToan() {
        return tinhTrang_ThanhToan;
    }

    public void setTinhTrang_ThanhToan(boolean tinhTrang_ThanhToan) {
        this.tinhTrang_ThanhToan = tinhTrang_ThanhToan;
    }
 
    
}
