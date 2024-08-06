/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import entity.SanPhamEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.XJDBC;

/**
 *
 * @author manht
 */
public class SanPhamDAO extends storeDAO<SanPhamEntity, String> {

    @Override
    public void insert(SanPhamEntity sp) {
        String sql = "INSERT INTO SanPham (tenSP,SoLuong,GiaBan,Anh,GhiChu,MaDM,Size) VALUES (?,?,?,?,?,?,?)";
        XJDBC.update(sql,
              //sp.getMaSP(), //Vì là mã tự sinh nên k cần nhập
                sp.getTenSP(),
                sp.getSoLuong(),
                sp.getGiaBan(),
                sp.getAnh(),
                sp.getGhiChu(),
                sp.getMaDM(),
                sp.getSize()
        );
    }

    @Override
    public void update(SanPhamEntity sp) {
        String sql = "UPDATE SanPham SET tenSP = ?, SoLuong = ?, giaBan = ?, anh = ?, ghiChu = ?, MaDM = ?, size = ? WHERE maSP = ?";
        XJDBC.update(sql,
                sp.getTenSP(),
                sp.getSoLuong(),
                sp.getGiaBan(),
                sp.getAnh(),
                sp.getGhiChu(),
                sp.getMaDM(),
                sp.getSize(),
                sp.getMaSP()
        );
    }

    @Override
    public void delete(String maSP) {
        String sql = "DELETE FROM SanPham WHERE maSP = ?";
        XJDBC.update(sql, maSP);
    }

    @Override
    public SanPhamEntity selectById(String maSP) {
        String sql = "SELECT * FROM SanPham WHERE maSP = ?";
        List<SanPhamEntity> listSP = selectBySql(sql, maSP);
        return listSP.size() > 0 ? listSP.get(0) : null;
    }

    @Override
    public List<SanPhamEntity> selectAll() {
        String sql = "SELECT * FROM SanPham";
        return this.selectBySql(sql);
    }

    @Override
    protected List<SanPhamEntity> selectBySql(String sql, Object... args) {
        List<SanPhamEntity> listSP = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJDBC.query(sql, args);
                while (rs.next()) {
                    SanPhamEntity sp = new SanPhamEntity();
                    sp.setMaSP(rs.getString("MaSP"));
                    sp.setTenSP(rs.getString("tenSP"));
                    sp.setSoLuong(rs.getInt("SoLuong"));
                    sp.setGiaBan(rs.getFloat("GiaBan"));
                    sp.setAnh(rs.getString("Anh"));
                    sp.setGhiChu(rs.getString("GhiChu"));
                    sp.setMaDM(rs.getInt("MaDM"));
                    sp.setSize(rs.getString("Size"));
                    listSP.add(sp);

                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listSP;
    }

    public List<SanPhamEntity> selectSPByDanhMuc(int maDM) { //Tìm kiếm sản phẩm theo danh mục sản phẩm
        String sql = "SELECT * FROM SanPham WHERE MaDM = ?";
        return this.selectBySql(sql, maDM);
    }
    
    public List<SanPhamEntity> selectByKeyword(String keyword){ //Tìm kiếm sản phẩm theo keyword
        String sql = "SELECT * FROM SanPham WHERE tenSP LIKE ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }
        public Float giaTien(String maSP){
         String sql="select GiaBan from SanPham where MaSP=?" ;
         Float count=null;
         try {
             ResultSet result=XJDBC.query(sql, maSP);
             
             while(result.next()){
               count= result.getFloat(1);// lấy bắt đầu từ số đầu tiên
             }
         } catch (SQLException e) {
             System.out.println("Lấy năm không thành công"+e);
         }
         return count;
    } 
}
