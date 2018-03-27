package com.playgrounds.DTO;

import com.playgrounds.domen.Playground;
import com.playgrounds.domen.Region;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.maven.lifecycle.internal.LifecycleStarter;

import java.util.List;

public class RegionDTO {

    private Region region;
    private List<PlaygroundDTO> playgroundsDtos;

    public RegionDTO(){}

    public RegionDTO(Region region, List<PlaygroundDTO> playgroundsDtos){
        this.region = region;
        this.playgroundsDtos = playgroundsDtos;
    }

    public RegionDTO(Region region){
        this.region = region;
    }

    public Region getRegion() {
        return region;
    }

    public List<PlaygroundDTO> getPlaygroundsDtos() {
        return playgroundsDtos;
    }
}
