package com.example.basic_auth_rest1.service;

import com.example.basic_auth_rest1.User;
import com.example.basic_auth_rest1.utilities.exceptions.UserLoginException;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class UserService {
    final List<User> users;

    public UserService(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public User addUser(User user) {

        user.isValid();

        Optional<User> matchingUser = users.stream()
                .filter(u -> u.getUsername().equals(user.getUsername()))
                .findFirst();

        if (matchingUser.isPresent()) {
            throw UserLoginException.builder()
                    .message("Username already exists")
                    .hint("Try a different username")
                    .build();
        } else {
            users.add(user);
        }

        return user;
    }

    public boolean removeUser(String username) {
        Predicate<User> isMatch = user -> user.getUsername().equals(username);

        boolean foundMatch = users.removeIf(isMatch);

        System.out.println("Found match: " + foundMatch);
        return foundMatch;
    }


}
