/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.controllers;

import com.dv.pojo.ChuyenXe;
import com.dv.services.ChuyenXeService;
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
public class ChuyenXeController {
         @Autowired
    private ChuyenXeService chuyenXeService;
    @GetMapping("/admin/chuyenxes")
    public String createView(Model model) {
        model.addAttribute("chuyenXe", new ChuyenXe());
        return "chuyenxes";
    }
    @PostMapping("/admin/chuyenxes")
    public String createChuyenXe(@ModelAttribute (value = "chuyenXe") @Valid ChuyenXe cx,
            BindingResult rs) { //1. ModelAttribute có 2 công dụng : + 1 là xài chung, 2 là gửi backing beans    Sau đó đóng gói lại đối tượng HoatDong h(Desireilizer)
        //Tất cả lõi sẽ hiện ở BindingResult rs
        if(!rs.hasErrors()) {
            try {
                this.chuyenXeService.addOrUpdate(cx);
                return "redirect:/";
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        System.err.println(rs);
        return "chuyenxes";

        
    }
    
    @GetMapping("/admin/chuyenxes/{tuyenxeId}")
    public String updateView (Model model,@PathVariable(value = "chuyenxeId")int id) {
        
        model.addAttribute("chuyenXe",        this.chuyenXeService.getChuyenXeByID(id));
        return "chuyenxes";

    }
}
