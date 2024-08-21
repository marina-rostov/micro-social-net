package com.example.microsocialnet.service;

import com.example.microsocialnet.entity.User;
import com.example.microsocialnet.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;

import javax.persistence.PersistenceException;
import java.time.LocalDate;
import java.util.Date;


class UserServiceTest {

    @Test
    void createUser() {
        //given
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        User user = new User(
                new Date(),
                "user1@test.org",
                "Vasiliy",
                "Petrov",
                LocalDate.of(2020, 1, 8),
                "man",
                "ava_petrov_001.jpeg",
                "характер скверный, не женат",
                false,
                1L,
                1L
        );
        User savedUser = new User(
                1L,
                new Date(),
                "user1@test.org",
                "Vasiliy",
                "Petrov",
                LocalDate.of(2020, 1, 8),
                "man",
                "ava_petrov_001.jpeg",
                "характер скверный, не женат",
                false,
                1L,
                1L
        );
        Mockito.when(userRepository.save(user)).thenReturn(savedUser);
        UserService userService = new UserService(userRepository);

        //when
        String result = userService.createUser(user);

        //then
        Assertions.assertEquals("Пользователь Petrov добавлен в базу с id = 1", result);
    }

    @Test
    void createUserError() {
        //given
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        User user = new User(
                new Date(),
                "user1@test.org",
                "Vasiliy",
                "Petrov",
                LocalDate.of(2020, 1, 8),
                "man",
                "ava_petrov_001.jpeg",
                "характер скверный, не женат",
                false,
                1L,
                1L
        );
        Mockito.when(userRepository.save(user)).thenThrow(PersistenceException.class);
        UserService userService = new UserService(userRepository);


        //when
        Executable executable = ()-> userService.createUser(user);

        //then
        Assertions.assertThrows(PersistenceException.class, executable);
    }
}