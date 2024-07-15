/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author TUF
 */
public class DanhMucSPEntity {

    private int maDM;
    private String tenDM;

    public DanhMucSPEntity(int maDM, String tenDM) {
        this.maDM = maDM;
        this.tenDM = tenDM;
    }
    
    // COMBOBOX
    public DanhMucSPEntity(String tenDM) {
        this.tenDM = tenDM;
    }

    public DanhMucSPEntity() {
    }

    public int getMaDM() {
        return maDM;
    }

    public void setMaDM(int maDM) {
        this.maDM = maDM;
    }

    public String getTenDM() {
        return tenDM;
    }

    public void setTenDM(String tenDM) {
        this.tenDM = tenDM;
    }
    
    
}
