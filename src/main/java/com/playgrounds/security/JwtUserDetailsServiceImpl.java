package com.playgrounds.security;

import com.playgrounds.domen.User;
import com.playgrounds.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    private final Log logger = LogFactory.getLog(JwtUserDetailsServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User  user = userRepository.findByUserName(username);

        if (user == null) {
            logger.debug("Authentication user debug- " + username);
            logger.info("Authentication user info - " + username);

            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            logger.debug("Authenticated user debug - "+ username);
            logger.info("Authentication user info - " + username);
            return JwtUserFactory.create(user);
        }
    }
}
