package com.beyond.todolist.infrastructure.repository;

import com.beyond.todolist.core.model.User;
import com.beyond.todolist.infrastructure.entity.UserEntity;

public interface UserRepository {
    int create(UserEntity user);
    void update(String username, User user);
}
