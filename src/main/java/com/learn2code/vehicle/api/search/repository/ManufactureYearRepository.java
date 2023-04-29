package com.learn2code.vehicle.api.search.repository;

import com.learn2code.vehicle.api.search.entity.ManufactureYear;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufactureYearRepository extends JpaRepository<ManufactureYear, Integer> {
}
