package com.learn2code.vehicle.api.search.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.learn2code.vehicle.api.search.entity.Model;
import com.learn2code.vehicle.api.search.entity.TrimType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrimTypeDto {

    private int id;
    private String trimType;

}
