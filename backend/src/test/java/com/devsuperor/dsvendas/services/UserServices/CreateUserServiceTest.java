package com.devsuperor.dsvendas.services.UserServices;

import com.devsuperor.dsvendas.services.UserServices.DTOs.RequestCreateUserDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class CreateUserServiceTest {

    @InjectMocks
    CreateUserService createUserService;

    @Test
    void execute() {
        RequestCreateUserDTO user = new RequestCreateUserDTO("1","teste@teste.com","123456");
        Assertions.assertEquals("teste@teste.com", user.getEmail());
    }
}