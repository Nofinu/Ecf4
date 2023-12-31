package com.example.authentication.service;

import com.example.authentication.dto.UserDto;
import com.example.authentication.entity.UserApp;
import com.example.authentication.repository.UserAppRepository;
import org.apache.catalina.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserAppService {

    private final UserAppRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserAppService(UserAppRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public UserApp enregistrerUtilisateur(String username, String password) {
        UserApp user = new UserApp(username, password);
        return userRepository.save(user);
    }

}
