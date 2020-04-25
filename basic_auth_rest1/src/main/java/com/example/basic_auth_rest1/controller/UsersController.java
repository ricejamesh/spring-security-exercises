package com.example.basic_auth_rest1.controller;

import com.example.basic_auth_rest1.User;
import com.example.basic_auth_rest1.service.UserService;
import com.example.basic_auth_rest1.utilities.exceptions.UserLoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    final
    UserService usersService;

    public UsersController(UserService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/")
    public List<User> getUsers() {
        System.out.println("getUsers");
        return usersService.getUsers();
    }

    @DeleteMapping("/{id}")
    public int deleteUserByID(@PathVariable int id) {
        System.out.println("Deleting user: " + id);
        return id;
    }

    @DeleteMapping("/{username}")
    public String deleteUserByName(@PathVariable String username) {
        System.out.println("Deleting user: " + username);
        return username;
    }

    @PostMapping("/register")
    public User registerNewUser( @Valid @RequestBody User user ) {
        User myCopy = new User(user);
        User newUser = usersService.addUser(user);
        System.out.println("Created: " + user);
        return newUser;
    }



}
