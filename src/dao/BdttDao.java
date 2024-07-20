/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;

/**
 *
 * @author Tungg
 */
abstract public class BdttDao<EntityType, KeyType> {

    abstract public void insert(EntityType entity); //Entity: SanPham,NhanVien,KhachHang,....

    abstract public void update(EntityType entity);

    abstract public void delete(KeyType id); //KeyType:String,int,double,...

    abstract public EntityType selectById(KeyType id);

    abstract public List<EntityType> selectAll();

    abstract protected List<EntityType> selectBySql(String sql, Object... args);
}
