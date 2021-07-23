package com.devsuperor.dsvendas.repository;

import com.devsuperor.dsvendas.entities.User;
import com.devsuperor.dsvendas.repositories.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void init(){
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("Test result true of consult exist by email")
    public void ShouldBeAbleToReturnTrueWhenEmailExists(){
        // Cenario
        User user =  User.builder().name("John Doe").email("test@test.com").build();
        userRepository.save(user);
        // Acao
        boolean result = userRepository.existsByEmail("test@test.com");
        // Vericação
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Test result false of consult exist by email")
    public void ShouldBeAbleToReturnFalseWhenEmailNotExists(){
        // Cenario

        // Acao
        boolean result = userRepository.existsByEmail("test@test.com");
        // Vericação
        Assertions.assertFalse(result);
    }

}

