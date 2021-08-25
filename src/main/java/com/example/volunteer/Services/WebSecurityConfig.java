package com.example.volunteer.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DBUserDetailsServiceImplementation dbUserDetailsServiceImplementation;

    @Autowired
    DBVolunteerDetailsServiceImplementation dbVolunteerDetailsServiceImplementation;

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(dbVolunteerDetailsServiceImplementation).passwordEncoder(passwordEncoder());
        auth.userDetailsService(dbUserDetailsServiceImplementation).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().disable().csrf().disable().authorizeRequests()
                .antMatchers("/**").permitAll()
//                .antMatchers("/userPage","/askForHelp").hasAuthority("ROLE_USER")
//                .antMatchers("/volunteerPage","/volunteerSkill").hasAuthority("ROLE_VOLUNTEER")
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").loginProcessingUrl("/perform_login").defaultSuccessUrl("/", true)
                .failureUrl("/login").and().logout().logoutUrl("/perform_logout").deleteCookies("JSESSIONID");
    }
}
