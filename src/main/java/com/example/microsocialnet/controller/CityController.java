package com.example.microsocialnet.controller;

import com.example.microsocialnet.entity.City;
import com.example.microsocialnet.service.CityService;
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
@RequestMapping("/api/v1/cities")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @Operation(summary="Создание города")
    @PostMapping
    String createCity(@RequestBody City city) {
        return cityService.createCity(city);
    }

    @Operation(summary="Получение города по id")
    @GetMapping("/{id}")
    City getCity(@PathVariable long id) {
        return cityService.getCity(id);
    }

    @Operation(summary="Обновление города по id")
    @PutMapping("/{id}")
    String updateCity(@RequestBody City city, @PathVariable long id) {
        return cityService.updateCity(city, id);
    }

    @Operation(summary="Удаление города по id")
    @DeleteMapping("/{id}")
    String deleteCity(@PathVariable long id) {
        return cityService.deleteCity(id);
    }

    @Operation(summary="Получение списка всех городов")
    @GetMapping
    List<City> getCitys() {
        return cityService.getCities();
    }

}
