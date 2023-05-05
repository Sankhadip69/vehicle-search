package com.learn2code.vehicle.api.search.repository;

import com.learn2code.vehicle.api.search.entity.TrimType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrimTypeRepository extends JpaRepository<TrimType, Integer> {
}
