package com.touristicbot.natalliavasilyeva.controller;

import com.touristicbot.natalliavasilyeva.model.City;
import com.touristicbot.natalliavasilyeva.model.Description;
import com.touristicbot.natalliavasilyeva.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {

   private CityService cityService;

    @Autowired
    public void setCityService (CityService cityService){
        this.cityService=cityService;
    }

    @GetMapping("/cities")
    List<City> takeAllCities() {
        return cityService.getAllCities();
    }

    @PostMapping("/city")
    City createNewCity(@RequestBody City newCity) {
        return cityService.addCity(newCity);
    }

    // Single item

    @GetMapping("/cities/{id}")
    City takeOneCityById(@PathVariable Long id) {

        return cityService.findById(id);

    }

    @DeleteMapping("/cities/{id}")
    void deleteCity(@PathVariable Long id) {
        cityService.deleteById(id);
    }

    @GetMapping("/description/{cityName}")
    Description takeCityDescription(@PathVariable String cityName){
        return cityService.getByName(cityName).getDescription();
    }

}
