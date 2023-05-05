package com.learn2code.vehicle.api.search.mapper;

import com.learn2code.vehicle.api.search.entity.TrimType;
import com.learn2code.vehicle.api.search.payload.TrimTypeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TrimTypeMapper {


    TrimTypeDto mapToTrimTypeDto(TrimType trimType);

    List<TrimTypeDto> mapToDtoList(List<TrimType> trimTypeList);

    TrimType mapToTrimType(TrimTypeDto trimTypeDto);

}
