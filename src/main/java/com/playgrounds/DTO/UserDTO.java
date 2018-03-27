package com.playgrounds.DTO;

import com.playgrounds.domen.City;
import com.playgrounds.domen.Region;
import com.playgrounds.domen.User;

import java.io.Serializable;
public class UserDTO implements Serializable {

    private User user;
    private Region region;
    private City city;

    public UserDTO(User user, Region region, City city){
        this.user = user;

        this.region = region;
        this.city = city;
    }
}
