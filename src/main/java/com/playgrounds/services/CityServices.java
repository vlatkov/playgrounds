package com.playgrounds.services;

import com.playgrounds.domen.City;
import com.playgrounds.repository.CityRepository;
import com.playgrounds.repository.RegionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.plaf.synth.Region;
import java.util.List;

@Service
@Transactional
public class CityServices {

    private CityRepository cityRepository;
    private RegionRepository regionRepository;

    public CityServices(CityRepository cityRepository, RegionRepository regionRepository){
        this.cityRepository = cityRepository;
        this.regionRepository = regionRepository;
    }

    public List<City> findAllCitiesByCountry(Long Id){
        return cityRepository.findAllByCountry(Id);
    }
    public List<City> findAllByName(String name){
        return cityRepository.findAllByName(name);
    }

}
