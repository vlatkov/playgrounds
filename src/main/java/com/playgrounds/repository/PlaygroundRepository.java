package com.playgrounds.repository;

import com.playgrounds.domen.Playground;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaygroundRepository extends JpaRepository<Playground, Long> {

    List<Playground> findAllByRegion(Long regionId);

}
