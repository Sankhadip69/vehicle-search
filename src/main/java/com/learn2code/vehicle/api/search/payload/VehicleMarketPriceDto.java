package com.learn2code.vehicle.api.search.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleMarketPriceDto {

    private int id;
    private String modelYear;
    private String brandName;
    private String modelName;
    private String trimType;
    private double price;
}
