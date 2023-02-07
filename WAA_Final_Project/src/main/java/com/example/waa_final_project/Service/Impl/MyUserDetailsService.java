package com.example.waa_final_project.Service.Impl;

import com.example.waa_final_project.Reposetory.UsersRepo;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("userDetailsService")
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    private final UsersRepo userRepo;

    public MyUserDetailsService(UsersRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s)
            throws UsernameNotFoundException, DataAccessException {
        var user = userRepo.findByEmail(s).get();
        var userDetails = new MyUserDetails(user);
        return userDetails;
    }
}
