package com.example.authentication.security;


import com.example.authentication.entity.UserApp;
import com.example.authentication.repository.UserAppRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service

public class CustomUserDetailService implements UserDetailsService {

    private final UserAppRepository userAppRepository;

    public CustomUserDetailService(UserAppRepository userAppRepository) {
        this.userAppRepository = userAppRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserApp userApp = userAppRepository.findByUsername(username).get();
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("user"));
        return new User(userApp.getUsername(), userApp.getPassword(),authorities);
    }
}
