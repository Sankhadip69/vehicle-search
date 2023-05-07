package com.learn2code.vehicle.api.search.repository;

import com.learn2code.vehicle.api.search.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Integer> {

    List<Model> findByManufacturerId(int id);

    Model findByModelName(String name);

    @Query(value = "SELECT * FROM models WHERE manufacturer_id = ?1", nativeQuery = true)
    List<Model> fetchModelsBasedManufacturerId(int manufacturerId);
}
