package com.example.volunteer.Services;

import com.example.volunteer.Models.ApplicationVolunteer;
import com.example.volunteer.Models.DBVolunteer;
import com.example.volunteer.Repositories.DBVolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DBVolunteerDetailsServiceImplementation implements UserDetailsService {

    @Autowired
    DBVolunteerRepository dbVolunteerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DBVolunteer dbVolunteer = dbVolunteerRepository.findByUsername(username);

        // Error handling ... the user is equal to null (doesn't exist in the database)
        if (dbVolunteer == null) {
            throw new UsernameNotFoundException("The user " + username + " does not exist");
        }
        return new ApplicationVolunteer(dbVolunteer);
    }
}
