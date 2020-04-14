package com.touristicbot.natalliavasilyeva.service;

import com.touristicbot.natalliavasilyeva.exception.CityNotFoundException;
import com.touristicbot.natalliavasilyeva.model.City;
import com.touristicbot.natalliavasilyeva.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{

    private CityRepository cityRepository;

    @Autowired
    public void setCityRepository (CityRepository cityRepository){
        this.cityRepository=cityRepository;
    }

    @Override
    public City addCity(City city) {
        City savedCity = cityRepository.saveAndFlush(city);

        return savedCity;
    }

    @Override
    public void deleteById(long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public City getByName(String name) {
        return cityRepository.findByName(name);
    }

    @Override
    public City editCity(City city) {
        return cityRepository.saveAndFlush(city);
    }

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException(id));
    }



}
