/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.controllers;


import com.dv.pojo.ChuyenXe;
import com.dv.pojo.TuyenXe;
import com.dv.services.ChuyenXeService;
import com.dv.services.TaiXeService;
import com.dv.services.TuyenXeService;
import com.dv.services.XeService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ADMIN
 */
@Controller
@ControllerAdvice
public class ChuyenXeIndexController {
     @Autowired
    private ChuyenXeService chuyenXeService;
     @Autowired
   private TaiXeService taiXeService;
     @Autowired
   private XeService xeService;
        @Autowired
   private TuyenXeService tuyenXeService;
     
    @RequestMapping("/cx")
    public String index(Model model, @RequestParam Map<String, String> params) {
        // Assuming the service returns a map where keys are categories or some other distinction
         
        model.addAttribute("chuyenXes", this.chuyenXeService.getChuyenXes(params));
        return "chuyenxeindex";//Tìm trong tiles
    }

    @PostMapping("/home/chuyenxes")
    public String createChuyenXe(@ModelAttribute(value = "chuyenXe") @Valid ChuyenXe cx,
            BindingResult rs) {
        if (!rs.hasErrors()) {
            try {
                this.chuyenXeService.addOrUpdate(cx);
                return "redirect:/";
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return "chuyenxeindex";
    }

 @ModelAttribute//Tất cả các response trong Controller này sẽ có thông tin này, gắn ControllerAdvice sẽ dùng ModelAt tribute chung cho các controller khác
    public void commonAttribute(Model model,
             @RequestParam Map<String, String> params) {
      model.addAttribute("taiXes", this.taiXeService.getTaiXes());
      model.addAttribute("xes", this.xeService.getXes());
      model.addAttribute("tuyenXes", this.tuyenXeService.getTuyenXes(params));
    }
}

