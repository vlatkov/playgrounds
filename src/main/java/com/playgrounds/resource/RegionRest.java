package com.playgrounds.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.playgrounds.DTO.RegionDTO;
import com.playgrounds.domen.City;
import com.playgrounds.domen.Playground;
import com.playgrounds.domen.Region;
import com.playgrounds.domen.User;
import com.playgrounds.services.PlaygroundService;
import com.playgrounds.services.RegionServices;
import org.hyalinedto.api.DTO;
import org.hyalinedto.api.Hyaline;
import org.hyalinedto.exception.HyalineException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "${api.path}")
@Transactional
public class RegionRest {

    private final Logger log = LoggerFactory.getLogger(RegionRest.class);

    @Autowired
    RegionServices regionServices;

    @Autowired
    PlaygroundService playgroundService;

    @RequestMapping(value = "/region/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> findAllUser(@PathVariable Long id){

        log.debug("CALL region api with ID =  ", id);

        return regionServices.findOneMappedRegion(id);
        //userRepository.findAllByActive(active);
    }

    @RequestMapping(value = "/region/{regionId}/playgrounds",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Object allPlaygroundsFromRegion(@PathVariable Long regionId) throws HyalineException {

        return regionServices.getPlaygroundsFromRegion(regionId);
    }
}
