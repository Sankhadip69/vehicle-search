package com.learn2code.vehicle.api.search.service;

import com.learn2code.vehicle.api.search.entity.Model;
import com.learn2code.vehicle.api.search.payload.ModelDto;
import com.learn2code.vehicle.api.search.payload.TrimTypeDto;

public interface ModelTrimService {

    ModelDto saveModel(ModelDto modelDto);

    TrimTypeDto saveTrimType(TrimTypeDto trimTypeDto);
}
