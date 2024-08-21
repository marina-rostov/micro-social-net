package com.example.microsocialnet.repository;

import com.example.microsocialnet.entity.Friend;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface FriendRepository extends CrudRepository<Friend, Long> {
    Optional<Friend> findByUserIdFromAndUserIdTo(Long userIdFrom, Long userIdTo);
    List<Friend> findAll();
}
