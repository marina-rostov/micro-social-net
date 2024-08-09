package com.example.microsocialnet.controller;

import com.example.microsocialnet.entity.University;
import com.example.microsocialnet.service.UniversityService;
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

    @PostMapping
    String createUniversity(@RequestBody University university) {
        return universityService.createUniversity(university);
    }

    @GetMapping("/{id}")
    University getUniversity(@PathVariable long id) {
        return universityService.getUniversity(id);
    }

    @PutMapping("/{id}")
    String updateUniversity(@RequestBody University university, @PathVariable long id) {
        return universityService.updateUniversity(university, id);
    }

    @DeleteMapping("/{id}")
    String deleteUniversity(@PathVariable long id) {
        return universityService.deleteUniversity(id);
    }

    @GetMapping
    List<University> getUniversitys() {
        return universityService.getUniversities();
    }

}
