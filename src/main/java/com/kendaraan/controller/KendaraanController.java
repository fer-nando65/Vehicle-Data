package com.kendaraan.controller;

import com.kendaraan.dto.kendaraan.KendaraanUpsertDto;
import com.kendaraan.service.KendaraanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("upsert")
    public String upsert(@RequestParam(defaultValue = "") String id,
                         Model model){
        var detail = this.service.getkendaraan(id);
        var title = this.service.getTitle(id);
        model.addAttribute("kendaraanDetail", detail);
        model.addAttribute("listOptionColor", detail.getOptionColor());
        model.addAttribute("titleForm", title);
        return "kendaraan-form";
    }

    @PostMapping("upsert")
    public String upsert(KendaraanUpsertDto dto){
        this.service.save(dto);
        return "redirect:/kendaraan/index";
    }
}
