package com.example.basic_auth_rest1.configuration;

import com.example.basic_auth_rest1.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserConfiguration {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    List<User> getInitialUsers() {
        List<User> users = new ArrayList<>();
        User user1 = User.builder().id(1).firstName("Joseph").lastName("Smith").username("user1").password(passwordEncoder.encode("user123")).build();
        User user2 = User.builder().id(2).firstName("Jonathan").lastName("Doe").username("user2").password(passwordEncoder.encode("user456")).build();
        users.add(user1);
        users.add(user2);
        return users;
    }
}
