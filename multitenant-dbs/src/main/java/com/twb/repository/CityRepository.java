package com.twb.repository;

import com.twb.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CityRepository extends JpaRepository<City,Long> {

    City findById(Long id);

    City findByName(String name);

    void deleteByName(String name);
}
