package com.playgrounds.services;

import com.playgrounds.DTO.PlaygroundDTO;
import com.playgrounds.domen.Playground;
import com.playgrounds.domen.Region;
import com.playgrounds.repository.PlaygroundInfoRepository;
import com.playgrounds.repository.PlaygroundRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlaygroundService {

    private PlaygroundInfoRepository playgroundInfoRepository;
    private PlaygroundRepository playgroundRepository;

    public PlaygroundService(PlaygroundRepository playgroundRepository, PlaygroundInfoRepository playgroundInfoRepository)
    {
        this.playgroundInfoRepository = playgroundInfoRepository;
        this.playgroundRepository = playgroundRepository;

    }

    public PlaygroundDTO findOne(Long playgroundId){
        PlaygroundDTO playgroundDTO = new PlaygroundDTO();
        playgroundDTO.setPlaygroundInfos(playgroundInfoRepository.findByPlayground(playgroundId));
        playgroundDTO.setPlayground(playgroundRepository.findOne(playgroundId));

        return playgroundDTO;
    }
    public void delete(Playground playground){
        playgroundRepository.delete(playground);
    }

    public List<Playground> findAllPlaygroundByRegion(Region region){
            return playgroundRepository.findAllByRegion(region);
    }

}
