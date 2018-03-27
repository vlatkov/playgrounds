package com.playgrounds.services;

import com.playgrounds.DTO.PlaygroundDTO;
import com.playgrounds.domen.Playground;
import com.playgrounds.repository.PlaygroundInfoRepository;
import com.playgrounds.repository.PlaygroundRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public PlaygroundDTO findOne(Long id){
        PlaygroundDTO playgroundDTO = new PlaygroundDTO();
        playgroundDTO.setPlaygroundInfos(playgroundInfoRepository.findByPlayground(id));
        playgroundDTO.setPlayground(playgroundRepository.findOne(id));

        return playgroundDTO;
    }
    public void delete(Playground playground){
        playgroundRepository.delete(playground);
    }

}
