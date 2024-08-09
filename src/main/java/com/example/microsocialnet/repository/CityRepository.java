package com.example.microsocialnet.repository;

import com.example.microsocialnet.entity.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends CrudRepository<City, Long> {
    Optional<City> findByName(String name);
    List<City> findAll();
}
