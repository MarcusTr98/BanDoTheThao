package entity;

public class SanPhamEntity {

    private String maSP;
    private String tenSP;
    private int soLuong;
    private float giaBan;
    private String anh;
    private String ghiChu;
    private int maDM;
    private String size;

    public SanPhamEntity(String maSP, String tenSP, int soLuong, float giaBan, String anh, String ghiChu, int maDM, String size) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.anh = anh;
        this.ghiChu = ghiChu;
        this.maDM = maDM;
        this.size = size;
    }

    public SanPhamEntity(String tenSP) {
        this.tenSP = tenSP;
    }

    public SanPhamEntity() {
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getMaDM() {
        return maDM;
    }

    public void setMaDM(int maDM) {
        this.maDM = maDM;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    
    
}
