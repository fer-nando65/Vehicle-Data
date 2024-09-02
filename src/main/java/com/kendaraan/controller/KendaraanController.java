package com.kendaraan.controller;

import com.kendaraan.service.KendaraanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("kendaraan")
public class KendaraanController {
    @Autowired
    private KendaraanService service;

    @GetMapping("index")
    public String index(@RequestParam(defaultValue = "") String id,
                        @RequestParam(defaultValue = "") String ownerName,
                        Model model){
        var grid = this.service.get(id, ownerName);
        model.addAttribute("gridKendaraan", grid);
        return "kendaraan-index";
    }
}
