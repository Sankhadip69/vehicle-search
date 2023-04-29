package com.learn2code.vehicle.api.search.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ManufacturerDto {

    private int id;
    private String manufacturerName;
    private String countryOfOrigin;
}
