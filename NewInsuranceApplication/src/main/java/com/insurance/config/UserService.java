package com.insurance.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//@Service
//public class UserService implements UserDetailsService {
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        if ("admin".equals(username)) {
//            return new org.springframework.security.core.userdetails.User(
//                "admin",
//                passwordEncoder().encode("admin@123"),  // This is for initial setup; you'd typically want this encoded
//                new ArrayList<>()
//            );
//        } else {
//            throw new UsernameNotFoundException("User not found");
//        }
//    }
//}


@Service
public class UserService implements UserDetailsService {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        switch (username) {
            case "admin":
                return new org.springframework.security.core.userdetails.User(
                    "admin",
                    passwordEncoder().encode("admin@123"),  // Encoded password
                    new ArrayList<>()
                );
            case "user":
                return new org.springframework.security.core.userdetails.User(
                    "user",
                    passwordEncoder().encode("user@123"),  // Encoded password for another user
                    new ArrayList<>()
                );
            default:
                throw new UsernameNotFoundException("User not found");
        }
    }
}


