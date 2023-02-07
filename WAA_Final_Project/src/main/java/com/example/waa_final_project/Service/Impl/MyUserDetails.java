package com.example.waa_final_project.Service.Impl;


import com.example.waa_final_project.Entity.Role;
import com.example.waa_final_project.Entity.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class MyUserDetails implements UserDetails {

    //    these three fields are custom and added by me
    private String email;
    @JsonIgnore
    private String password;
    private Role roles;

    public MyUserDetails(Users user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles = user.getRole(); // this should be a list of roles
    }

//    @Override
//    public GrantedAuthority[] getAuthorities() {
//        return new GrantedAuthority[0];
//    }

    @Override
    // will change the return type to be one of this class
    // children using wild card of generics

//    public Collection<? extends GrantedAuthority> getAuthorities() {
//
//
//        return new SimpleGrantedAuthority(roles.getTitle());
//        return roles.stream()
//                .map( role -> new SimpleGrantedAuthority(role.getRole()))
//                .collect(Collectors.toList());
//    }


    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> rolesList = new ArrayList<>();
        rolesList.add(new SimpleGrantedAuthority(roles.getTitle()));
        return rolesList;
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
