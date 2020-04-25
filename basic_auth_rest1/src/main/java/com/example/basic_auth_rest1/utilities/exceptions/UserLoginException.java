package com.example.basic_auth_rest1.utilities.exceptions;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserLoginException extends RuntimeException {
    private String message;
    private String details;
    private String hint;
    private String nextActions;
    private String support;
}
