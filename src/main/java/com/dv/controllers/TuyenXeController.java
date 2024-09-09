/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.controllers;

import com.dv.pojo.TuyenXe;
import com.dv.services.TuyenXeService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



/**
 *
 * @author ADMIN
 */

@Controller
public class TuyenXeController {
     @Autowired
    private TuyenXeService tuyenXeService;
    @GetMapping("/admin/tuyenxes")
    public String createView(Model model) {
        model.addAttribute("tuyenXe", new TuyenXe());
        return "tuyenxes";
    }
    @PostMapping("/admin/tuyenxes")
    public String createTuyenXe(@ModelAttribute (value = "tuyenXe") @Valid TuyenXe tx,
            BindingResult rs) { //1. ModelAttribute có 2 công dụng : + 1 là xài chung, 2 là gửi backing beans    Sau đó đóng gói lại đối tượng HoatDong h(Desireilizer)
        //Tất cả lõi sẽ hiện ở BindingResult rs
        if(!rs.hasErrors()) {
            try {
                this.tuyenXeService.addOrUpdate(tx);
                return "redirect:/";
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        System.err.println(rs);
        return "tuyenxes";

        
    }
    
    @GetMapping("/admin/tuyenxes/{tuyenxeId}")
    public String updateView (Model model,@PathVariable(value = "tuyenxeId")int id) {
        
        model.addAttribute("tuyenXe",        this.tuyenXeService.getTuyenXeByID(id));
        return "tuyenxes";

    }
}

