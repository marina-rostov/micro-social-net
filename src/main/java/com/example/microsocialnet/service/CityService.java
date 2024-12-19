package com.example.microsocialnet.service;

import com.example.microsocialnet.entity.City;
import com.example.microsocialnet.repository.CityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public String createCity(City city) {
        if (cityRepository.findByName(city.getName()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        City savedCity = cityRepository.save(city);
        return String.format("Город %s добавлен в базу с id = %s", savedCity.getName(), savedCity.getId());
    }

    public City getCity(long id) {
        return cityRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public String updateCity(City city, long id) {
        if (!city.getId().equals(id)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "id в url не совпадает с id в теле запроса");
        }
        if (!cityRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        City savedCity = cityRepository.save(city);
        return String.format("Город %s успешно сохранен", savedCity.getName());
    }

    public String deleteCity(long id) {
        if (!cityRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        cityRepository.deleteById(id);
        return String.format("Город с id = %s успешно удален", id);
    }

    public List<City> getCities() {
        return cityRepository.findAll();
    }
}
