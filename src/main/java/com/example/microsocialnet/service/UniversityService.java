package com.example.microsocialnet.service;

import com.example.microsocialnet.entity.University;
import com.example.microsocialnet.repository.UniversityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UniversityService {
    private final UniversityRepository universityRepository;

    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public String createUniversity(University university) {
        if (universityRepository.findByName(university.getName()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        University savedUniversity = universityRepository.save(university);
        return String.format("Город %s добавлен в базу с id = %s", savedUniversity.getName(), savedUniversity.getId());
    }

    public University getUniversity(long id) {
        return universityRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public String updateUniversity(University university, long id) {
        if (!university.getId().equals(id)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "id в url не совпадает с id в теле запроса");
        }
        if (!universityRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        University savedUniversity = universityRepository.save(university);
        return String.format("Город %s успешно сохранен", savedUniversity.getName());
    }

    public String deleteUniversity(long id) {
        if (!universityRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        universityRepository.deleteById(id);
        return String.format("Город с id = %s успешно удален", id);
    }

    public List<University> getUniversities() {
        return universityRepository.findAll();
    }
}
