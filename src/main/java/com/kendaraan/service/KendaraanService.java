package com.kendaraan.service;

import com.kendaraan.dto.KendaraanIndexDto;

import java.util.List;

public interface KendaraanService {
    List<KendaraanIndexDto> get(String id, String ownerName);
}
