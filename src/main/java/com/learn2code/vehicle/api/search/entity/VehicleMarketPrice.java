package com.learn2code.vehicle.api.search.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "market_price")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleMarketPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "model_year")
    private String modelYear;
    @Column(name = "brand_name")
    private String brandName;
    @Column(name = "model_name")
    private String modelName;
    @Column(name = "trim_type")
    private String trimType;
    @Column(name = "price")
    private double price;
}
