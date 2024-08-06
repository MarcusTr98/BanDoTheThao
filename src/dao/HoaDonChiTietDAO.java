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
        String selectById="select MaHDCT,MaHDBan,hdct.maSP,sp.TenSP,hdct.soLuong,giamGia,((hdct.soLuong*sp.GiaBan)-GiamGia) as ThanhTien\n" +
"from hoaDonChiTiet hdct inner join sanpham sp on sp.maSP=hdct.maSP WHERE MaHDCT=?";
    String insert="insert into HoaDonChiTiet (MaHDBan,MaSP,soLuong,giamGia,thanhTien) values (?,?,?,?,?)";
    String update="update HoaDonChiTiet set MaHDBan=?,MaSP=?,SoLuong=?,GiamGia=?,thanhTien=? where MaHDCT=?";
    String delete ="delete from HoaDonChiTiet where MaHDCT=?";
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
    public HoaDonChiTietEntity selectById(int maHDCT){
        List<HoaDonChiTietEntity> list= this.selectBySql(selectById, maHDCT );
        return list.get(0);
    }
    public void insert (HoaDonChiTietEntity hdct){
        try {
                   XJDBC.update(insert,hdct.getMaHDBan(),hdct.getMaSP(),hdct.getSoLuong(),hdct.getGiamGia(),hdct.getThanhTien() );
                   System.out.println("insert thanh cong");
        } catch (Exception e) {
            System.out.println("insert that bai"+e);
        }
    }
    public void update(HoaDonChiTietEntity hdct){
        try {
                    XJDBC.update(update,hdct.getMaHDBan(),hdct.getMaSP(),hdct.getSoLuong(),
                            hdct.getGiamGia(),hdct.getThanhTien(),hdct.getMaHDCT());
                    System.out.println("update thanh cong");
        } catch (Exception e) {
            System.out.println("update that bai"+e);
        }
    }
    public void delete(int maHDCT){
        try {
                    XJDBC.update(delete, maHDCT);
                    System.out.println("delete thanh cong");
        } catch (Exception e) {
            System.out.println("delete that bai"+e);
        }
    }
        public Float DTDAY(){
        String sql="select sum(thanhTien) from HoaDonChiTiet hdct\n" +
"inner join HoaDon hd on hdct.MaHDBan=hd.MaHDBan\n" +
"where DAY(NgayBan)=GETDATE()" ;
         Float count=null;
         try {
             ResultSet result=XJDBC.query(sql);
             while(result.next()){
               count= result.getFloat(1);// lấy bắt đầu từ số đầu tiên
             }
         } catch (SQLException e) {
             System.out.println("Lấy năm không thành công"+e);
         }
         return count;
    }
        public Float DTMONTH(){
        String sql="select sum(thanhTien) from HoaDonChiTiet hdct\n" +
"inner join HoaDon hd on hdct.MaHDBan=hd.MaHDBan\n" +
"where MONTH(NgayBan)=1" ;
         Float count=null;
         try {
             ResultSet result=XJDBC.query(sql);
             while(result.next()){
               count= result.getFloat(1);// lấy bắt đầu từ số đầu tiên
             }
         } catch (SQLException e) {
             System.out.println("Lấy năm không thành công"+e);
         }
         return count;
    }
        public Float DTYEAR(){
        String sql="select sum(thanhTien) from HoaDonChiTiet hdct\n" +
"inner join HoaDon hd on hdct.MaHDBan=hd.MaHDBan\n" +
"where YEAR(NgayBan)=2021" ;
         Float count=null;
         try {
             ResultSet result=XJDBC.query(sql);
             while(result.next()){
               count= result.getFloat(1);// lấy bắt đầu từ số đầu tiên
             }
         } catch (SQLException e) {
             System.out.println("Lấy năm không thành công"+e);
         }
         return count;
    }
}
