package com.learn2code.vehicle.api.search.service.impl;

import com.learn2code.vehicle.api.search.entity.Model;
import com.learn2code.vehicle.api.search.entity.TrimType;
import com.learn2code.vehicle.api.search.exception.ModelNotFoundException;
import com.learn2code.vehicle.api.search.exception.TrimTypeNotFoundException;
import com.learn2code.vehicle.api.search.mapper.ModelMapper;
import com.learn2code.vehicle.api.search.mapper.TrimTypeMapper;
import com.learn2code.vehicle.api.search.payload.ModelDto;
import com.learn2code.vehicle.api.search.payload.TrimTypeDto;
import com.learn2code.vehicle.api.search.repository.ModelRepository;
import com.learn2code.vehicle.api.search.repository.TrimTypeRepository;
import com.learn2code.vehicle.api.search.service.ModelTrimService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import io.micrometer.common.util.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
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

    @Override
    public ModelDto modifyModelDto(ModelDto modelDto, int id) {
        Optional<Model> optionalModel = modelRepository.findById(id);
        if(optionalModel.isPresent()){
            Model model = optionalModel.get();
            if(modelDto.getModelName() != null &&
                    !modelDto.getModelName().isBlank() &&
                    !modelDto.getModelName().isEmpty()){
                model.setModelName(modelDto.getModelName());
            }
            return modelMapper.mapToModelDto(modelRepository.save(model));
        }else {
            throw new ModelNotFoundException("Model not found for id: " + id);
        }
    }

    @Override
    public TrimTypeDto modifyTrimTypeDto(TrimTypeDto trimTypeDto, int id) {
        Optional<TrimType> optionalTrimType = trimTypeRepository.findById(id);
        if(optionalTrimType.isPresent()) {
            TrimType trimType = optionalTrimType.get();
            if(trimType.getTrimType() != null &&
                    !trimType.getTrimType().isEmpty() &&
                    !trimType.getTrimType().isBlank()) {
                trimType.setTrimType(trimTypeDto.getTrimType());
            }
            return trimTypeMapper.mapToTrimTypeDto(trimTypeRepository.save(trimType));
        }else {
            throw new TrimTypeNotFoundException("TrimType not found for id: " + id);
        }
    }
}
