package com.learn2code.vehicle.api.search.service.impl;

import com.learn2code.vehicle.api.search.entity.Model;
import com.learn2code.vehicle.api.search.mapper.ModelMapper;
import com.learn2code.vehicle.api.search.mapper.TrimTypeMapper;
import com.learn2code.vehicle.api.search.payload.ModelDto;
import com.learn2code.vehicle.api.search.payload.TrimTypeDto;
import com.learn2code.vehicle.api.search.repository.ModelRepository;
import com.learn2code.vehicle.api.search.repository.TrimTypeRepository;
import com.learn2code.vehicle.api.search.service.ModelTrimService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelTrimServiceImpl implements ModelTrimService {

    private ModelRepository modelRepository;

    private TrimTypeRepository trimTypeRepository;
    private ModelMapper modelMapper;

    private TrimTypeMapper trimTypeMapper;


    @Override
    public ModelDto saveModel(ModelDto modelDto) {
        return modelMapper
                .mapToModelDto(modelRepository.save(modelMapper.mapToModel(modelDto)));
    }

    @Override
    public TrimTypeDto saveTrimType(TrimTypeDto trimTypeDto) {
        return trimTypeMapper
                .mapToTrimTypeDto(trimTypeRepository
                        .save(trimTypeMapper.mapToTrimType(trimTypeDto)));
    }

    @Override
    public List<ModelDto> getAllModels() {
        return modelRepository.findAll().stream().map(modelMapper::mapToModelDto)
                .collect(Collectors.toList());
    }
}
