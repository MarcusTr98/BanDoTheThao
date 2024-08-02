/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import entity.HoaDonEntity;
import java.util.*;
import java.sql.*;
import utils.*;
/**
 *
 * @author HP
 */
public class HoaDonDAO {
    String selectAll="select * from HoaDon";
    String selectById="select * from HoaDon where MaHDBan=?";
    String insert="insert into HoaDon values (?,?,?,?,?)";
    String update="update HoaDon set MaNV=?,NgayBan=?,MaKH=?,TinhTrang_ThanhToan=? where MaHDBan=?";
    String delete ="delete from HoaDon where MaHDBan=?";
    public List<HoaDonEntity> selectBySql(String sql,Object...args){
        List<HoaDonEntity> list= new ArrayList<>();
        try {
            ResultSet result= XJDBC.query(sql, args);
            while(result.next()){
                HoaDonEntity hd= new HoaDonEntity();
                hd.setMaHDBan(result.getString("MaHDBan"));
                hd.setMaNV(result.getInt("MaNV"));
                hd.setNgayBan(result.getDate("NgayBan"));
                hd.setMaKH(result.getInt("MaKH"));
                hd.setTinhTrang_ThanhToan(result.getBoolean("TinhTrang_ThanhToan"));
                list.add(hd);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
       
    }
    public List<HoaDonEntity> selectAll(){
        return this.selectBySql(selectAll);
    }
    public HoaDonEntity selectById(String maHD){
        List <HoaDonEntity> list= this.selectBySql(selectById, maHD);
        return list.get(0);
    }
    public void insert (HoaDonEntity hd){
        try {
            XJDBC.update(insert, hd.getMaHDBan(),hd.getMaNV(),hd.getNgayBan(),hd.getMaKH(),hd.isTinhTrang_ThanhToan());
            System.out.println("insert thanh cong");
        } catch (Exception e) {
            System.out.println("insert that bai"+e);
        }
      
    }
    public void update(HoaDonEntity hd){
        try {
                    XJDBC.update(update,hd.getMaNV(),hd.getNgayBan(),hd.getMaKH(),hd.isTinhTrang_ThanhToan(), hd.getMaHDBan());
                    System.out.println("update thanh cong");
        } catch (Exception e) {
            System.out.println("update that bai"+e);
        }
    }
    public void delete(String maHD){
        try {
                    XJDBC.update(delete, maHD);
                    System.out.println("delete thanh cong");
        } catch (Exception e) {
            System.out.println("delete that bai"+e);
        }
    }
}
