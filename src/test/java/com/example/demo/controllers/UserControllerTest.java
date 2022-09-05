package com.example.demo.controllers;

import com.example.demo.controller.UserController;
import com.example.demo.repository.UserRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private UserController userController;

    @BeforeAll
    void user() {

    }

    @Test
    void shouldGetAllUsers() {
    }

    @Test
    void  shouldReturnErrorIfNoUsersPresent() {
    }

    @Test
    void shouldReturnUserById() {

    }

    @Test
    void shouldReturnErrorIfNoUserExitsById() {

    }

    @Test
    void shouldCreateNewUserIfValidDataIsPassed() {

    }

    @Test
    void shouldReturnErrorIfInvalidDataIsPassed() {

    }
}
