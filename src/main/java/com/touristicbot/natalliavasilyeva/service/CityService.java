package com.touristicbot.natalliavasilyeva.service;

import com.touristicbot.natalliavasilyeva.model.City;

import java.util.List;

public interface CityService {

    City addCity(City city);
    void deleteById(long id);
    City getByName(String name);
    City editCity(City city);
    List<City> getAllCities();
    City findById(Long id);

}
