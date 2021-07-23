package com.devsuperor.dsvendas.services.UserServices;

import com.devsuperor.dsvendas.entities.User;
import com.devsuperor.dsvendas.exceptios.ExceptionRule;
import com.devsuperor.dsvendas.providers.HashProvider.implementations.JavaSecurityHashProvider;
import com.devsuperor.dsvendas.repositories.UserRepository;
import com.devsuperor.dsvendas.services.UserServices.DTOs.RequestCreateUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Service
public class CreateUserService  {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaSecurityHashProvider javaSecurityHashProvider;


    public User execute(RequestCreateUserDTO params) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        boolean checkEmailExist = userRepository.existsByEmail(params.getEmail());
        if (checkEmailExist){
            throw new ExceptionRule("this email already exist");
        }
        String hashedPassword = javaSecurityHashProvider.generateHash(params.getPassword());
        User newUser = User.builder()
                .name(params.getName())
                .email(params.getEmail())
                .password(hashedPassword)
                .build();
        return userRepository.save(newUser);
    }


}
