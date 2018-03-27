package com.playgrounds.repository;

import com.playgrounds.domen.RegistrationPlayground;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationPlaygroundRepository extends JpaRepository<RegistrationPlayground, Long> {

}
