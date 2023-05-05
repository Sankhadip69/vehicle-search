package com.learn2code.vehicle.api.search.repository;

import com.learn2code.vehicle.api.search.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {
}
