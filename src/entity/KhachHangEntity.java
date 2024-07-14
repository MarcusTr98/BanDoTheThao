package entity;

public class KhachHangEntity {
    private int maKH; // tự sinh
    private String tenKH;
    private String sdt;
    private boolean thanhVien = false; //mặc định là không 

    public KhachHangEntity(int maKH, String tenKH, String sdt) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.sdt = sdt;
    }

    public KhachHangEntity() {
    }

    public KhachHangEntity(String tenKH) {
        this.tenKH = tenKH;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public boolean isThanhVien() {
        return thanhVien;
    }

    public void setThanhVien(boolean thanhVien) {
        this.thanhVien = thanhVien;
    }
    
}

