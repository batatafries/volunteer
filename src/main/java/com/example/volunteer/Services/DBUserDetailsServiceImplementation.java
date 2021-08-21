package com.example.volunteer.Services;

import com.example.volunteer.Models.ApplicationUser;
import com.example.volunteer.Models.DBUser;
import com.example.volunteer.Repositories.DBUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DBUserDetailsServiceImplementation implements UserDetailsService {

    @Autowired
    DBUserRepository dbUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DBUser dbUser = dbUserRepository.findByUsername(username);

        // Error handling ... the user is equal to null (doesn't exist in the database)
        if (dbUser == null) {
            throw new UsernameNotFoundException("The user " + username + " does not exist");
        }
        return new ApplicationUser(dbUser);
    }
}