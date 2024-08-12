package com.example.microsocialnet.controller;

import com.example.microsocialnet.entity.University;
import com.example.microsocialnet.service.UniversityService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/universities")
public class UniversityController {
    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @Operation(summary="Создание университета")
    @PostMapping
    String createUniversity(@RequestBody University university) {
        return universityService.createUniversity(university);
    }

    @Operation(summary="Получение университета по id")
    @GetMapping("/{id}")
    University getUniversity(@PathVariable long id) {
        return universityService.getUniversity(id);
    }

    @Operation(summary="Обновление университета по id")
    @PutMapping("/{id}")
    String updateUniversity(@RequestBody University university, @PathVariable long id) {
        return universityService.updateUniversity(university, id);
    }

    @Operation(summary="Удаление университета по id")
    @DeleteMapping("/{id}")
    String deleteUniversity(@PathVariable long id) {
        return universityService.deleteUniversity(id);
    }

    @Operation(summary="Получение списка всех университетов")
    @GetMapping
    List<University> getUniversitys() {
        return universityService.getUniversities();
    }

}
