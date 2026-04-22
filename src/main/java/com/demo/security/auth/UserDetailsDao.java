package com.demo.security.auth;

import java.util.Optional;

public interface UserDetailsDao {
    Optional<CustomUser> getUserByUsername(String username);
}
