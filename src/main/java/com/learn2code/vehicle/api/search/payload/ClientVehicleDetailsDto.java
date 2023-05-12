package com.learn2code.vehicle.api.search.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientVehicleDetailsDto {

    private int id;
    private String modelYear;
    private String brandName;
    private String modelName;
    private String trimType;
    private String bodyType;
    private double price;
    private String estimatedMonthly;
    private int miles;
    private String dealType;
    private String amountBelowMarket;
    private String location;
    private String sellerName;
    private String sellerPhone;
}
