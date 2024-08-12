package com.example.microsocialnet.controller;

import com.example.microsocialnet.entity.User;
import com.example.microsocialnet.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary="Создание пользователя")
    @PostMapping
    String createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @Operation(summary="Получение пользователя по id")
    @GetMapping("/{id}")
    User getUser(@PathVariable long id) {
        return userService.getUser(id);
    }

    @Operation(summary="Обновление пользователя по id")
    @PutMapping("/{id}")
    String updateUser(@RequestBody User user, @PathVariable long id) {
        return userService.updateUser(user, id);
    }

    @Operation(summary="Удаление пользователя по id")
    @DeleteMapping("/{id}")
    String deleteUser(@PathVariable long id) {
        return userService.deleteUser(id);
    }

    @Operation(summary="Получение списка всех пользователей")
    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }

}
