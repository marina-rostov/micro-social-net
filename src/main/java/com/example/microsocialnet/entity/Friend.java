package com.example.microsocialnet.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userIdFrom;

    private Long userIdTo;

    public Friend() {

    }

    public Friend(Long id, Long userIdFrom, Long userIdTo) {
        this.id = id;
        this.userIdFrom = userIdFrom;
        this.userIdTo = userIdTo;
    }

    public Long getId() {
        return id;
    }

    public Long getUserIdFrom() {
        return userIdFrom;
    }

    public Long getUserIdTo() {
        return userIdTo;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", userIdFrom=" + userIdFrom +
                ", userIdTo=" + userIdTo +
                '}';
    }
}
