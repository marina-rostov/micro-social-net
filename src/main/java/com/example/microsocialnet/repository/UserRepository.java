package com.example.microsocialnet.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.microsocialnet.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByLastNameAndFirstName(String lastName, String firstName);
    List<User> findAll();
}
