/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.services.impl;

import com.dv.pojo.ChuyenXe;
import com.dv.repositoties.ChuyenXeRepository;
import com.dv.services.ChuyenXeService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class ChuyenXeServiceImpl implements ChuyenXeService{
    
    @Autowired
    private ChuyenXeRepository chuyenXeRepo;
    
    
    @Override
    public List<ChuyenXe> getChuyenXes(Map<String, String> params) {
        return this.chuyenXeRepo.getChuyenXes(params);

    }

    @Override
    public void addOrUpdate(ChuyenXe cv) {
        this.chuyenXeRepo.addOrUpdate(cv);

    }

    @Override
    public ChuyenXe getChuyenXeByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteChuyenXe(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
