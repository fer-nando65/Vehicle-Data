package com.kendaraan.service.implementation;

import com.kendaraan.dto.kendaraan.KendaraanIndexDto;
import com.kendaraan.dto.kendaraan.KendaraanUpsertDto;
import com.kendaraan.dto.option.OptionDto;
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

    @Override
    public List<KendaraanIndexDto> get(String id, String ownerName){
        List<Kendaraan> listKendaraan = this.repository.getAll(id, ownerName);

        int rowNumber = 1;
        List<KendaraanIndexDto> dto = new LinkedList<>();
        for(var kendaraan : listKendaraan){
            var kendaraanDto = new KendaraanIndexDto();
            kendaraanDto.setRowNumber(rowNumber);
            kendaraanDto.setId(kendaraan.getId());
            kendaraanDto.setOwnerName(kendaraan.getOwnerName());
            kendaraanDto.setBrand(kendaraan.getBrand());
            kendaraanDto.setProductionYear(kendaraan.getProductionYear());
            kendaraanDto.setCylinderCapacity(String.format("%s %s", Integer.toString(kendaraan.getCylinderCapacity()), "cc"));
            kendaraanDto.setColor(getColor(kendaraan.getColor()));
            kendaraanDto.setFuelType(kendaraan.getFuelType());

            dto.add(kendaraanDto);

            rowNumber = rowNumber + 1;
        }

        return dto;
    }

    @Override
    public KendaraanUpsertDto getkendaraan(String id){
        var dto = new KendaraanUpsertDto();
        if(!(id.equals(""))){
            var kendaraan = this.repository.findById(id).orElseThrow();
            dto.setId(kendaraan.getId());
            dto.setOwnerName(kendaraan.getOwnerName());
            dto.setBrand(kendaraan.getBrand());
            dto.setAddress(kendaraan.getAddress());
            dto.setProductionYear(kendaraan.getProductionYear());
            dto.setCylinderCapacity(kendaraan.getCylinderCapacity());
            dto.setFuelType(kendaraan.getFuelType());
            dto.setOptionColor(getOptionColor(kendaraan.getColor()));

            for(var opt : dto.getOptionColor()){
                if(opt.getSelected()){
                    dto.setColor(opt.getText());
                }
            }
        }else {
            dto.setOptionColor(getOptionColor(""));
        }

        return dto;
    }

    public List<OptionDto> getOptionColor(String color) {
        List<OptionDto> listOptColor = new LinkedList<>();

        var optColor = new OptionDto("Merah", "merah", false);
        listOptColor.add(optColor);
        optColor = new OptionDto("Hitam", "hitam", false);
        listOptColor.add(optColor);
        optColor = new OptionDto("Biru", "biru", false);
        listOptColor.add(optColor);
        optColor = new OptionDto("Abu-Abu", "abu-abu", false);
        listOptColor.add(optColor);

        for(var opt : listOptColor){
            if(opt.getValue().equals(color)){
                opt.setSelected(true);
            }
        }

        return listOptColor;
    }

    public String getColor(String color){
        List<OptionDto> listOptColor = getOptionColor(color);
        String selectedColor = "";
        for(var opt : listOptColor){
            if(opt.getSelected()){
                selectedColor = opt.getText();
            }
        }

        return selectedColor;
    }

    @Override
    public void save(KendaraanUpsertDto dto){
        var kendaraan = new Kendaraan();
        kendaraan.setId(dto.getId());
        kendaraan.setOwnerName(dto.getOwnerName());
        kendaraan.setAddress(dto.getAddress());
        kendaraan.setBrand(dto.getBrand());
        kendaraan.setProductionYear(dto.getProductionYear());
        kendaraan.setCylinderCapacity(dto.getCylinderCapacity());
        kendaraan.setColor(dto.getColor());
        kendaraan.setFuelType(dto.getFuelType());

        this.repository.save(kendaraan);
    }

    @Override
    public void delete(String id){
        var kendaraan = this.repository.findById(id).orElseThrow();
        this.repository.delete(kendaraan);
    }
}
