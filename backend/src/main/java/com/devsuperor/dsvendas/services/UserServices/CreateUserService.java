package com.devsuperor.dsvendas.services.UserServices;

import com.devsuperor.dsvendas.entities.User;
import com.devsuperor.dsvendas.exceptios.ExceptionRule;
import com.devsuperor.dsvendas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    User authenticate(String email, String senha){
        User user = User.builder().build();
        return user;
    }

    public Boolean findByEmail(String email){
      boolean exist = userRepository.existsByEmail(email);

      if (exist){
          throw new ExceptionRule("Email já Cadastrado");
      }
          return false;

    }

    public User Create(User user){
        findByEmail(user.getEmail());
        userRepository.save(user);
        return user;
    }


}
