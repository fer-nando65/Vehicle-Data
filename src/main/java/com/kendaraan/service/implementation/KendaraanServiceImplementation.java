package com.kendaraan.service.implementation;

import com.kendaraan.dto.KendaraanIndexDto;
import com.kendaraan.entity.Kendaraan;
import com.kendaraan.repository.KendaraanRepository;
import com.kendaraan.service.KendaraanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class KendaraanServiceImplementation implements KendaraanService {
    @Autowired
    private KendaraanRepository repository;

    public List<KendaraanIndexDto> get(String id, String ownerName){
        List<Kendaraan> listKendaraan = this.repository.getAll(id, ownerName);

        Integer rowNumber = 1;
        List<KendaraanIndexDto> dto = new LinkedList<>();
        for(var kendaraan : listKendaraan){
            var kendaraanDto = new KendaraanIndexDto();
            kendaraanDto.setRowNumber(rowNumber);
            kendaraanDto.setId(kendaraan.getId());
            kendaraanDto.setOwnerName(kendaraan.getOwnerName());
            kendaraanDto.setBrand(kendaraan.getBrand());
            kendaraanDto.setProductionYear(kendaraan.getProductionYear());
            kendaraanDto.setCylinderCapacity(String.format("%s %s", Integer.toString(kendaraan.getCylinderCapacity()), "cc"));
            kendaraanDto.setColor(kendaraan.getColor());
            kendaraanDto.setFuelType(kendaraan.getFuelType());
            dto.add(kendaraanDto);

            rowNumber = rowNumber + 1;
        }

        return dto;
    }
}
