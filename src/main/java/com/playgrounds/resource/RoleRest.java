package com.playgrounds.resource;

import com.playgrounds.domen.Role;
import com.playgrounds.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class RoleRest {

    private RoleRepository roleRepository;

    public RoleRest(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    @RequestMapping(value = "/roles", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Role> findAllRoles()
    {
        return roleRepository.findAllBy();
    }

    @RequestMapping(value = "/roles/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Role findRoleById(@PathVariable Long id)
    {
        return roleRepository.findOne(id);
    }
}

