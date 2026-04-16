package com.demo.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static com.demo.security.config.ApplicationUserRole.*;

@Service
public class FakeUserDetailsService implements UserDetailsDao {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeUserDetailsService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public CustomUser getUserByUsername(String username) {
        return getListCustomUsers().stream()
                .filter(customUser -> customUser.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    private List<CustomUser> getListCustomUsers() {
        return Arrays.asList(
                new CustomUser("anna",
                        passwordEncoder.encode("123456"),
                        STUDENT.getAuthorities(),
                        true, true,
                        true, true
                ),
                new CustomUser("linda",
                        passwordEncoder.encode("123456"),
                        ADMIN.getAuthorities(),
                        true, true,
                        true, true
                ),
                new CustomUser("tom",
                        passwordEncoder.encode("123456"),
                        ADMINTRAINEE.getAuthorities(),
                        true, true,
                        true, true
                )
        );
    }
}
