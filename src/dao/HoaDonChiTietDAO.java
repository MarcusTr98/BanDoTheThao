/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.XJDBC;

/**
 *
 * @author HP
 */
public class HoaDonChiTietDAO {
        String selectAll="select MaHDCT,MaHDBan,hdct.maSP,sp.TenSP,hdct.soLuong,giamGia,((hdct.soLuong*sp.GiaBan)-GiamGia) as ThanhTien\n" +
"from hoaDonChiTiet hdct inner join sanpham sp on sp.maSP=hdct.maSP";
    String insert="insertt into HoaDonChiTiet values (?,?,?,?,?,?)";
    String update="update HoaDonChiTiet MaHDBan=?,MaSP=?,SoLuong=?,GiamGia=?,thanhTien=? where MaHDCT=?";
    String delete ="delete from HoaDon where MaHDCT=?";
    public List<HoaDonChiTietEntity> selectBySql(String sql,Object...args){
        List<HoaDonChiTietEntity> list= new ArrayList<>();
        try {
            ResultSet result= XJDBC.query(sql, args);
            while(result.next()){
               HoaDonChiTietEntity hdct= new HoaDonChiTietEntity();
               hdct.setMaHDCT(result.getInt("MaHDCT"));
               hdct.setMaHDBan(result.getString("MaHDBan"));
               hdct.setMaSP(result.getString("MaSP"));
               hdct.setTenSP(result.getString("TenSP"));
                 hdct.setSoLuong(result.getInt("SoLuong"));
                 hdct.setGiamGia(result.getFloat("GiamGia"));
                 hdct.setThanhTien(result.getFloat("thanhTien"));
                 list.add(hdct);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
       
    }
    public List<HoaDonChiTietEntity> selectAll(){
        return this.selectBySql(selectAll);
    }
    public void insert (HoaDonChiTietEntity hdct){
       XJDBC.update(insert,hdct.getMaHDCT(),hdct.getMaHDBan() );
    }
    public void update(HoaDonEntity hd){
        XJDBC.update(update,hd.getMaNV(),hd.getNgayBan(),hd.getMaKH(),hd.isTinhTrang_ThanhToan(), hd.getMaHDBan());
    }
    public void delete(String maHDCT){
        XJDBC.update(delete, maHDCT);
    }
}
