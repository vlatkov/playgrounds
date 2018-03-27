package com.playgrounds.repository;

import com.playgrounds.domen.PlaygroundInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaygroundInfoRepository extends JpaRepository<PlaygroundInfo, Long> {

    List<PlaygroundInfo> findByPlayground(Long id);
}
