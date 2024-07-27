/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.ResultSet;
import entity.NhanVienEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.XJDBC;
/**
 *
 * @author manht
 */
public class NhanVienDAO extends storeDAO<NhanVienEntity, String> {

    @Override
    public void insert(NhanVienEntity nv) {
        String sql = "INSERT INTO NhanVien (TenNV,GioiTinh,DiaChi,SDT,NgaySinh,MatKhau,VaiTro) VALUES (?,?,?,?,?,?)";
        XJDBC.update(sql,
//                     nv.getMaNV()
                       nv.getTenNV(),
                       nv.isGioiTinh(),
                       nv.getDiaChi(),
                       nv.getSdt(),
                       nv.getNgaySinh(),
                       nv.getMatKhau(),
                       nv.isVaiTro());
    }

    @Override
    public void update(NhanVienEntity nv) {
        String sql = "UPDATE NhanVien SET tenNV = ?, gioiTinh = ?, diaChi = ?, sdt = ?, NgaySinh = ?, MatKhau = ?, VaiTro = ? WHERE MaNV = ?";
                XJDBC.update(sql,
                       nv.getTenNV(),
                       nv.isGioiTinh(),
                       nv.getDiaChi(),
                       nv.getSdt(),
                       nv.getNgaySinh(),
                       nv.getMatKhau(),
                       nv.isVaiTro(),
                       nv.getMaNV());
    }

    @Override
    public void delete(String maNV) {
        String sql = "DELETE FROM NhanVien WHERE MaNV = ?";
        XJDBC.update(sql, maNV);
    }

    @Override
    public NhanVienEntity selectById(String maNV) {
        String sql = "SELECT * FROM NhanVIen WHERE MaNV = ?";
        List<NhanVienEntity> listNV = selectBySql(sql, maNV);
        return listNV.size() > 0 ? listNV.get(0) : null;
    }

    @Override
    public List<NhanVienEntity> selectAll() {
        String sql = "SELECT * FROM NhanVien";
        return this.selectBySql(sql);
    }

    @Override
    protected List<NhanVienEntity> selectBySql(String sql, Object... args) {
        List<NhanVienEntity> listNV = new ArrayList<>();
        try{
            ResultSet rs = null;
            try{
                rs = XJDBC.query(sql, args);
                while(rs.next()){
                    NhanVienEntity nv = new NhanVienEntity();
                    nv.setMaNV(rs.getInt("MaNV"));
                    nv.setTenNV(rs.getString("TenNV"));
                    nv.setGioiTinh(rs.getBoolean("GioiTinh"));
                    nv.setDiaChi(rs.getString("DiaChi"));
                    nv.setSdt(rs.getString("SDT"));
                    nv.setNgaySinh(rs.getDate("NgaySinh"));
                    nv.setMatKhau(rs.getString("MatKhau"));
                    nv.setVaiTro(rs.getBoolean("VaiTro"));
                    listNV.add(nv);
                }
            }finally{
                rs.getStatement().getConnection().close();
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return listNV;
    }
    public void qmk(NhanVienEntity nv){
        String sql = "UPDATE NhanVien SET MatKhau = ? WHERE MaNV = ?";
        XJDBC.update(sql, nv.getMatKhau(),nv.getMaNV());
    }
}
