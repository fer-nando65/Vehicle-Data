package com.kendaraan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Kendaraan")
public class Kendaraan {
    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "OwnerName", length = 50, nullable = false)
    private String ownerName;

    @Column(name = "Address", length = 200)
    private String address;

    @Column(name = "Brand", length = 20)
    private String brand;

    @Column(name = "ProductionYear")
    private Integer productionYear;

    @Column(name = "CylinderCapacity")
    private Integer cylinderCapacity;

    @Column(name = "Color")
    private String color;

    @Column(name = "FuelType")
    private String fuelType;
}
