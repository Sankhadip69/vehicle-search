package com.learn2code.vehicle.api.search.mapper;

import com.learn2code.vehicle.api.search.entity.Model;
import com.learn2code.vehicle.api.search.payload.ModelDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ModelMapper {


    ModelDto mapToModelDto(Model model);

    List<ModelDto> mapToModelDtoList(List<Model> modelList);

    Model mapToModel(ModelDto modelDto);

}
