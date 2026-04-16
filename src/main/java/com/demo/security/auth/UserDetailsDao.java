package com.demo.security.auth;

public interface UserDetailsDao {
    CustomUser getUserByUsername(String username);
}
