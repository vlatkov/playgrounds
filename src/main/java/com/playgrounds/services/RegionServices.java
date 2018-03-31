package com.playgrounds.services;

import com.playgrounds.DTO.GenericDTO;
import com.playgrounds.DTO.PlaygroundDTO;
import com.playgrounds.DTO.RegionDTO;
import com.playgrounds.domen.Playground;
import com.playgrounds.domen.Region;
import com.playgrounds.repository.PlaygroundRepository;
import com.playgrounds.repository.RegionRepository;
import org.springframework.stereotype.Service;

import javax.management.Attribute;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegionServices {

    RegionRepository regionRepository;
    PlaygroundRepository playgroundRepository;
    PlaygroundService playgroundService;

    public RegionServices(RegionRepository regionRepository, PlaygroundService playgroundService){
        this.regionRepository = regionRepository;
        this.playgroundService = playgroundService;
    }

    public RegionDTO findOne(Long regionId) {

        Region region = regionRepository.findOne(regionId);
        List<Playground> playgrounds = playgroundService.findAllPlaygroundByRegion(regionId);

        GenericDTO genericDTO = null;
        try {
            Attribute attribute = new Attribute("test",playgroundService.findOne(1L));
            genericDTO.add("playground",attribute);
        } catch (Exception e){

        }

        RegionDTO regionDTO = new RegionDTO();
        PlaygroundDTO playgroundDTO = new PlaygroundDTO();

        regionDTO.setRegion(regionRepository.findOne(regionId));
        regionDTO.setPlaygroundsDtos((List<PlaygroundDTO>)playgroundDTO);
        return regionDTO;
    }

    public List<Region> allRegion(){
        return regionRepository.findAll();
    }

}
