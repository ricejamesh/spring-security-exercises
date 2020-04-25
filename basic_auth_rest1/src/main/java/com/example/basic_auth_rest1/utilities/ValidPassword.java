package com.example.basic_auth_rest1.utilities;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 *
 *  Note: Validators require something to initiate validation.  In a rest endpoint,
 *  you need to add the @Valid qualifier.
 *
 *  <br><br>
 *  <pre>
 *  &#64;PostMapping("/register")
 *  public User registerNewUser( <b>@Valid</b> @RequestBody User user ) {
 *  ...
 *  }
 *  </pre>
 */
@Documented
@Constraint(validatedBy = PasswordConstraintValidator.class)
@Target({ TYPE, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
public @interface ValidPassword {

    String message() default "Invalid Password";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}