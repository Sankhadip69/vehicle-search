package com.learn2code.vehicle.api.search.payload;

import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "* Manufacturer name is required")
    private String manufacturerName;


    private String countryOfOrigin;
}
