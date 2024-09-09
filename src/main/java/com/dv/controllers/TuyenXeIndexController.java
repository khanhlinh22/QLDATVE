/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.controllers;


import com.dv.pojo.TuyenXe;
import com.dv.services.TuyenXeService;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ADMIN
 */
@Controller
@ControllerAdvice
public class TuyenXeIndexController {
 
    @Autowired
    private TuyenXeService tuyenXeService;
     
    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {
        // Assuming the service returns a map where keys are categories or some other distinction
         
        model.addAttribute("tuyenXes", this.tuyenXeService.getTuyenXes(params));
        return "index";//Tìm trong tiles
    }

    @PostMapping("/home/tuyenxes")
    public String createTuyenXe(@ModelAttribute(value = "tuyenXe") @Valid TuyenXe tx,
            BindingResult rs) {
        if (!rs.hasErrors()) {
            try {
                this.tuyenXeService.addOrUpdate(tx);
                return "redirect:/";
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return "index";
    }


}