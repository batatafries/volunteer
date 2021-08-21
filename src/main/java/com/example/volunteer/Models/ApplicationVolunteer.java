package com.example.volunteer.Models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ApplicationVolunteer implements UserDetails {

    private DBVolunteer dbVolunteer;

    public ApplicationVolunteer(DBVolunteer dbVolunteer) {
        this.dbVolunteer = dbVolunteer;
    }

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
       SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(dbVolunteer.getAuthority());
       List<SimpleGrantedAuthority> volunteerAuthorities = new ArrayList<>();
       volunteerAuthorities.add(simpleGrantedAuthority);
       return volunteerAuthorities;
   }

    @Override
    public String getPassword() {
        return dbVolunteer.getPassword();
    }

    @Override
    public String getUsername() {
        return dbVolunteer.getUsername();
    }

    public Integer getId() {
        return dbVolunteer.getId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
