package com.playgrounds.DTO;


import com.playgrounds.domen.Playground;
import com.playgrounds.domen.PlaygroundInfo;

import java.util.List;

public class PlaygroundDTO {

    private Playground playground;
    private List<PlaygroundInfo> playgroundInfos;

    public PlaygroundDTO(){}

    public PlaygroundDTO(Playground playground, List<PlaygroundInfo> playgroundInfo) {
        this.playground = playground;
        this.playgroundInfos = playgroundInfo;
    }

    public Playground getPlayground() {
        return playground;
    }

    public void setPlayground(Playground playground) {
        this.playground = playground;
    }

    public List<PlaygroundInfo> getPlaygroundInfos() {
        return playgroundInfos;
    }

    public void setPlaygroundInfos(List<PlaygroundInfo> playgroundInfos) {
        this.playgroundInfos = playgroundInfos;
    }
}