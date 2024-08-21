package com.example.microsocialnet.repository;

import com.example.microsocialnet.entity.University;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UniversityRepository extends CrudRepository<University, Long> {
    Optional<University> findByName(String name);
    List<University> findAll();
}
