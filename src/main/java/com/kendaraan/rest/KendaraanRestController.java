package com.kendaraan.rest;

import com.kendaraan.service.KendaraanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kendaraan")
public class KendaraanRestController {
    @Autowired
    private KendaraanService service;

    @GetMapping("/delete/{id}")
    public ResponseEntity<Object> deleteKendaraan(@PathVariable String id){
        try {
            this.service.delete(id);
            return ResponseEntity.ok().body("Success");
        }catch (Exception exception){
            return ResponseEntity.internalServerError().body("Runtime Error");
        }
    }

}
