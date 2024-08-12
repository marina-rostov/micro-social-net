package com.example.microsocialnet.controller;

import com.example.microsocialnet.entity.Friend;
import com.example.microsocialnet.service.FriendService;
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
@RequestMapping("/api/v1/friends")
public class FriendController {
    private final FriendService friendService;

    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }

    @Operation(summary="Создание друзей")
    @PostMapping
    String createFriend(@RequestBody Friend friend) {
        return friendService.createFriend(friend);
    }

    @Operation(summary="Получение друзей по id")
    @GetMapping("/{id}")
    Friend getFriend(@PathVariable long id) {
        return friendService.getFriend(id);
    }

    @Operation(summary="Обновление друзей по id")
    @PutMapping("/{id}")
    String updateFriend(@RequestBody Friend friend, @PathVariable long id) {
        return friendService.updateFriend(friend, id);
    }

    @Operation(summary="Удаление друзей по id")
    @DeleteMapping("/{id}")
    String deleteFriend(@PathVariable long id) {
        return friendService.deleteFriend(id);
    }

    @Operation(summary="Получение списка всех друзей")
    @GetMapping
    List<Friend> getFriends() {
        return friendService.getFriends();
    }

}
