package com.example.microsocialnet.controller;

import com.example.microsocialnet.entity.City;
import com.example.microsocialnet.service.CityService;
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
@RequestMapping("/api/v1/cities")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    String createCity(@RequestBody City city) {
        return cityService.createCity(city);
    }

    @GetMapping("/{id}")
    City getCity(@PathVariable long id) {
        return cityService.getCity(id);
    }

    @PutMapping("/{id}")
    String updateCity(@RequestBody City city, @PathVariable long id) {
        return cityService.updateCity(city, id);
    }

    @DeleteMapping("/{id}")
    String deleteCity(@PathVariable long id) {
        return cityService.deleteCity(id);
    }

    @GetMapping
    List<City> getCitys() {
        return cityService.getCities();
    }

}
