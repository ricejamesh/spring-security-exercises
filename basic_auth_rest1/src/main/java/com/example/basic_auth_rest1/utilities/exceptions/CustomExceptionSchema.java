package com.example.basic_auth_rest1.utilities.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@JsonInclude(Include.NON_NULL)
public class CustomExceptionSchema {
    private String message;
    private String details;
    private String hint;
    private String nextActions;
    private String support;
}
