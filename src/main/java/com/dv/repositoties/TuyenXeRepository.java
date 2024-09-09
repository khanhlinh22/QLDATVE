/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.repositoties;

import com.dv.pojo.TuyenXe;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public interface TuyenXeRepository {
    List<TuyenXe> getTuyenXes(Map<String, String> params);
    void addOrUpdate(TuyenXe tx); 
    TuyenXe getTuyenXeID(int id);
    void deleteTuyenXe(int id);
}
