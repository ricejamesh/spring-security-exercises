package com.example.basic_auth_rest1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserTest {

    @Autowired
    private Validator validator;

    @Test
    void badPassword() {
        // given
        String username = "simple";
        String password = "simple";

        // when
        User newUser = new User(0, username, password, "first", "last");
        Set<ConstraintViolation<User>> violations = validator.validate(newUser);
        // then
        assertEquals(1, violations.size());
    }

    @Test
    void goodPassword() {
        // given
        String username = "simple";
        String password = "M@gicfv42";

        // when
        User newUser = new User(0, username, password, "first", "last");
        Set<ConstraintViolation<User>> violations = validator.validate(newUser);
        // then
        assertEquals(0, violations.size());
    }
}