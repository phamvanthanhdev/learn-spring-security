package com.demo.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final FakeUserDetailsService userDetailsService;

    @Autowired
    public CustomUserDetailsService(FakeUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public CustomUser loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<CustomUser> user = userDetailsService.getUserByUsername(username);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new BadCredentialsException("User not found");
        }
    }
}
