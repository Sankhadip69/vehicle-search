package com.learn2code.vehicle.api.search.service.impl;

import com.learn2code.vehicle.api.search.entity.Manufacturer;
import com.learn2code.vehicle.api.search.exception.ManufacturerNotFoundException;
import com.learn2code.vehicle.api.search.exception.MissingFieldException;
import com.learn2code.vehicle.api.search.mapper.ManufacturerMapper;
import com.learn2code.vehicle.api.search.payload.ManufacturerDto;
import com.learn2code.vehicle.api.search.repository.ManufacturerRepository;
import com.learn2code.vehicle.api.search.service.ManufacturerService;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ManufacturerServiceImpl implements ManufacturerService {

    private ManufacturerRepository manufacturerRepository;
    private ManufacturerMapper manufacturerMapper;

    @Override
    public ManufacturerDto saveManufacturer(ManufacturerDto manufacturerDto) {
       return manufacturerMapper.mapToManufacturerDto(manufacturerRepository
                .save(manufacturerMapper.mapToManufacturer(manufacturerDto)));
    }

    @Override
    public List<ManufacturerDto> fetchAllManufacturers() {
        List<Manufacturer> manufacturers = manufacturerRepository.findAll();
        return manufacturers.stream()
                .map(manufacturerMapper::mapToManufacturerDto).collect(Collectors.toList());
    }

    @Override
    public ManufacturerDto getManufacturerForId(int id) {
        Manufacturer dbManufacturer = manufacturerRepository.findById(id).orElseThrow(
                () -> new ManufacturerNotFoundException("manufacturer", "id", id)
        );
        return manufacturerMapper.mapToManufacturerDto(dbManufacturer);
    }

    @Override
    public ManufacturerDto updateManufacturer(ManufacturerDto manufacturerDto, int id) {
        Optional<Manufacturer> optionalManufacturer = manufacturerRepository.findById(id);
        if (optionalManufacturer.isPresent()) {
            Manufacturer manufacturer = optionalManufacturer.get();
            if (StringUtils.isNotBlank(manufacturerDto.getManufacturerName())) {
                manufacturer.setManufacturerName(manufacturerDto.getManufacturerName());
            }
            if (StringUtils.isNotBlank(manufacturerDto.getCountryOfOrigin())) {
                manufacturer.setCountryOfOrigin(manufacturerDto.getCountryOfOrigin());
            }
            manufacturer = manufacturerRepository.save(manufacturer);
            return manufacturerMapper.mapToManufacturerDto(manufacturer);
        } else {
            throw new MissingFieldException("Manufacturer name is required");
        }
    }


}
