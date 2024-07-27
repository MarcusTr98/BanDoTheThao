/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;

/**
 *
 * @author manht
 */
abstract public class storeDAO <EntityType, KeyType> {
    abstract public void insert(EntityType entity); //EntityType: SanPham, NhanVien, KhachHang...
    abstract public void update(EntityType entity);
    abstract public void delete(KeyType id); //KeyType: String, Integer, Double...
    abstract public EntityType selectById(KeyType id);
    abstract public List<EntityType> selectAll();
    abstract protected List<EntityType> selectBySql(String sql, Object...args);
}
