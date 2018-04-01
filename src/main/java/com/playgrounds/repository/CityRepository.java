package com.playgrounds.repository;

import com.playgrounds.domen.City;
import com.playgrounds.domen.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findAllByName(String name);
    List<City> findAllByCountry(Long Id);

}
