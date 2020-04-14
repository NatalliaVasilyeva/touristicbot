package com.touristicbot.natalliavasilyeva.repository;

import com.touristicbot.natalliavasilyeva.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CityRepository extends JpaRepository<City, Long> {

    @Query("select c from City c where c.cityName = :name")
    City findByName(@Param("name") String name);

}
