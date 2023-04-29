package com.learn2code.vehicle.api.search.service.impl;

import com.learn2code.vehicle.api.search.entity.Manufacturer;
import com.learn2code.vehicle.api.search.mapper.ManufacturerMapper;
import com.learn2code.vehicle.api.search.payload.ManufacturerDto;
import com.learn2code.vehicle.api.search.repository.ManufacturerRepository;
import com.learn2code.vehicle.api.search.service.ManufacturerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ManufacturerServiceImpl implements ManufacturerService {

    private ManufacturerRepository manufacturerRepository;

    @Override
    public ManufacturerDto saveManufacturer(ManufacturerDto manufacturerDto) {
        Manufacturer manufacturer = ManufacturerMapper.mapToManufacturer(manufacturerDto);
        Manufacturer savedManufacturer = manufacturerRepository.save(manufacturer);
        ManufacturerDto savedManufacturerDto = ManufacturerMapper.mapToManufactureDto(manufacturer);
        return savedManufacturerDto;
    }

    @Override
    public List<ManufacturerDto> fetchAllManufacturers() {
        List<Manufacturer> manufacturers = manufacturerRepository.findAll();
        return manufacturers.stream().map(ManufacturerMapper::mapToManufactureDto).collect(Collectors.toList());
    }

    @Override
    public Optional<ManufacturerDto> getManufacturerForId(int id) {
        return Optional.ofNullable(ManufacturerMapper.mapToManufactureDto
                (manufacturerRepository.findById(id).orElse(null)));
    }
}
