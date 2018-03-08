package com.playgrounds.resource;

import com.playgrounds.domen.User;
import com.playgrounds.repository.RoleRepository;
import com.playgrounds.repository.UserRepository;

import com.playgrounds.services.UserServices;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("/api")
@Transactional
public class UserRest {

    private final Logger log = LoggerFactory.getLogger(UserRest.class);


    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    private UserServices userServices;

    public UserRest(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository){

        this.userRepository = userRepository;

        this.roleRepository = roleRepository;
    }


    @RequestMapping(value = "signup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity signUp(@RequestBody User user)
    {
        try {
            int i = 0;
            // save to database

            if (userServices.exists(user) == null)
            {
                User newUser = userServices.create(user);
                log.info("SUCCESS - CREATED USER -" + user.getUserName());


                return ResponseEntity.created(new URI("/user/" + newUser.getId())).body(newUser);

            } else return new ResponseEntity(HttpStatus.BAD_REQUEST);

        } catch (RuntimeException e) {

            log.info("ERROR - CONFLICT CREATE USER -" + user.getUserName());
            return ResponseEntity.status(HttpStatus.CONFLICT).build();

        } catch (URISyntaxException e) {
            log.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }

    }

    @RequestMapping(value = "/users/{active}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> findAllUserByActive(@PathVariable boolean active){

        log.debug("CALL signup api with state ", active);

        return userServices.allUser();
        //userRepository.findAllByActive(active);
    }

}
