/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.services.impl;

import com.dv.pojo.TuyenXe;
import com.dv.repositoties.TuyenXeRepository;
import com.dv.services.TuyenXeService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class TuyenXeServiceImpl implements TuyenXeService {

    @Autowired
    private TuyenXeRepository tuyenXeRepo;

    @Override
    public List<TuyenXe> getTuyenXes(Map<String, String> params) {
        return this.tuyenXeRepo.getTuyenXes(params);
    }

    @Override
    public void addOrUpdate(TuyenXe tx) {
          this.tuyenXeRepo.addOrUpdate(tx);
    }

    @Override
    public TuyenXe getTuyenXeByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteTuyenXe(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
