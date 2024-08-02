/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.*;
import java.sql.*;
import utils.XJDBC;

/**
 *
 * @author HP
 */
public class ThongKeDAO {
      private List<Object[]> getListOfArray(String sql, String[] cols, Object...args){
        try {
            List<Object[]> list=new ArrayList<>();
            ResultSet rs = XJDBC.query(sql, args);
            while(rs.next()){
                Object[] vals = new Object[cols.length];
                for(int i=0; i<cols.length; i++){
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
       public List<Object[]> getSanPhamDaBan(){
          String sql="sp_sanphamdaban";
          String [] cols={"MaSP","TenSP","tenDM","tongTien"};
          return this.getListOfArray(sql, cols);
      }
         public List<Object[]> getSanPhamTonKho(){
          String sql="sp_sanphamtonkho";
          String [] cols={"MaSP","TenSP","SoLuongTonKho","tenDM","TongTien"};
          return this.getListOfArray(sql, cols);
      }
     public List<Object[]> getDoanhThu(){
         String sql="sp_doanhthu";
         String [] cols={"SoHD","MaSP","doanhThu","thapNhat","caoNhat","trungBinh"};
         return this.getListOfArray(sql, cols);
     }
      public List<Object[]> getDoanhThuNam(int nam){
         String sql="sp_doanhthunam(?)";
         String [] cols={"SoHD","MaSP","doanhThu","thapNhat","caoNhat","trungBinh"};
         return this.getListOfArray(sql, cols, nam);
     }
     
}
