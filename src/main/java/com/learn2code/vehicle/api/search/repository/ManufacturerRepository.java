package com.learn2code.vehicle.api.search.repository;

import com.learn2code.vehicle.api.search.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {
}
