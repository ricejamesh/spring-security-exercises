package com.example.basic_auth_rest1.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder)
                .withUser("user").password(passwordEncoder.encode("user123")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder.encode("admin123")).roles("USER", "ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Override
    protected void configure_Orig(HttpSecurity http) throws Exception {

        http.authorizeRequests()
//                .antMatchers("/", "/welcome", "/login").permitAll()
                .antMatchers("/", "/welcome", "/login", "/error").permitAll()
                .antMatchers("/hello-world/**").hasRole("USER")
                .antMatchers("/authenticated/**").hasAnyRole("ADMIN", "USER")
                .and().formLogin()
                .and().logout().logoutSuccessUrl("/welcome").permitAll()
                .and().exceptionHandling().accessDeniedPage("/error")
                .and().csrf().disable();
    }

    /*
        SPA configuration.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/welcome", "/login", "/error").permitAll()
                .antMatchers("/hello-world/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/authenticated/**").hasRole("ADMIN")
                .and()//
                // Return 403 accessing resources that require authentication
                .exceptionHandling().authenticationEntryPoint(new Http403ForbiddenEntryPoint()).and()//
                .httpBasic().and()
                .formLogin().permitAll()//
                // If login fails, return 401
                .failureHandler(new HTTPStatusHandler(HttpStatus.UNAUTHORIZED))//
                // If login succeeds return 200
                .successHandler(new HTTPStatusHandler(HttpStatus.OK)).and()//
                .logout()//
                // If logout succeeds return 200
                .logoutSuccessHandler(new HTTPStatusHandler(HttpStatus.OK));//

        http.csrf().disable();
    }
}
