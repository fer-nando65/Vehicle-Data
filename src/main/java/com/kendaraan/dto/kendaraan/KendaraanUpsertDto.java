package com.kendaraan.dto.kendaraan;

import com.kendaraan.dto.option.OptionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class KendaraanUpsertDto {
    private String id;
    private String ownerName;
    private String brand;
    private String address;
    private Integer productionYear;
    private Integer cylinderCapacity;
    private String color;
    private String fuelType;

    private List<OptionDto> optionColor;
}
