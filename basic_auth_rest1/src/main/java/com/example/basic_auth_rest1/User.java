package com.example.basic_auth_rest1;

import com.example.basic_auth_rest1.utilities.ValidPassword;
import com.example.basic_auth_rest1.utilities.exceptions.UserLoginException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
public class User {
    private int id;

    private String username;

    @ValidPassword
    private String password;

    private String firstName;
    private String lastName;

    private User() {
        // no-arg Jackson constructor
    }

    public User(User user) {
        this.username = user.username;
        this.password = user.password;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.id = user.id;
    }

    public boolean isValid() {
        if (username == null || username.length() < 3) {
            System.out.println("Username is too short");
            throw UserLoginException.builder()
                    .message("Username is invalid")
                    .hint("Use a length greater than 3")
                    .build();
        }

        if (password == null || password.length() < 3) {
            System.out.println("password is too short");
            throw UserLoginException.builder()
                    .message("Password is invalid")
                    .hint("Use a length greater than 3")
                    .build();
        }

        return true;
    }
}

