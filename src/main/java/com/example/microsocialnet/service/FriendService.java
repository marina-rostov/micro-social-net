package com.example.microsocialnet.service;

import com.example.microsocialnet.entity.Friend;
import com.example.microsocialnet.repository.FriendRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FriendService {
    private final FriendRepository friendRepository;

    public FriendService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    public String createFriend(Friend friend) {
        if (friendRepository.findByUserIdFromAndUserIdTo(friend.getUserIdFrom(), friend.getUserIdTo()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Friend savedFriend = friendRepository.save(friend);
        return String.format("Город %s добавлен в базу с id = %s", savedFriend.getUserIdFrom(), savedFriend.getId());
    }

    public Friend getFriend(long id) {
        return friendRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public String updateFriend(Friend friend, long id) {
        if (!friend.getId().equals(id)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "id в url не совпадает с id в теле запроса");
        }
        if (!friendRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Friend savedFriend = friendRepository.save(friend);
        return String.format("Город %s успешно сохранен", savedFriend.getUserIdFrom());
    }

    public String deleteFriend(long id) {
        if (!friendRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        friendRepository.deleteById(id);
        return String.format("Город с id = %s успешно удален", id);
    }

    public List<Friend> getFriends() {
        return friendRepository.findAll();
    }
}
