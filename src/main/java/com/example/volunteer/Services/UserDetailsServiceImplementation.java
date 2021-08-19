package com.example.volunteer.Services;

import com.example.volunteer.Models.UserS;
import com.example.volunteer.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserS user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username + " doesn't exist");
        }
        return user;
    }
}
