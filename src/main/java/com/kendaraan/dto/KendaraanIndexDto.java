package com.kendaraan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class KendaraanIndexDto {
    private Integer rowNumber;
    private String id;
    private String ownerName;
    private String brand;
    private Integer productionYear;
    private String cylinderCapacity;
    private String color;
    private String fuelType;
}
