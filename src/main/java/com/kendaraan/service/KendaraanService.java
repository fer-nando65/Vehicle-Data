package com.kendaraan.service;

import com.kendaraan.dto.kendaraan.KendaraanIndexDto;
import com.kendaraan.dto.kendaraan.KendaraanUpsertDto;

import java.util.List;

public interface KendaraanService {
    List<KendaraanIndexDto> get(String id, String ownerName);
    KendaraanUpsertDto getkendaraan(String id);
    void save(KendaraanUpsertDto dto);
    void delete(String id);
}
