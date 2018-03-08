package com.playgrounds.services;

import com.playgrounds.domen.Region;
import com.playgrounds.domen.User;
import com.playgrounds.repository.RoleRepository;
import com.playgrounds.repository.UserRepository;
import com.playgrounds.resource.UserRest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;


@Service
@Transactional
public class UserServices {

    private final Logger log = LoggerFactory.getLogger(UserRest.class);

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserRepository userRepository;
    private RoleRepository roleRepository;


    public UserServices(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

    }


    public void validateUser(String userName) {
        this.userRepository.findUserByUserName(userName).orElseThrow(
                () -> new UserFoundException(userName));
    }

    public User create(User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }

    public User exists(User user){
        return userRepository.findByUserName(user.getUserName());
    }

    @Transactional
    public List<User> allUser(){
        List<User> list = userRepository.findAll();
        for (User user:list) {
           Long i = user.getId();
           log.info(user.getRegion().toString());
        }

        return list;
    }

    public void deleteUSer(User user) {
        userRepository.delete(user);
    }

    public User findOne(String userName) {
        return userRepository.findByUserName(userName);
    }
}


