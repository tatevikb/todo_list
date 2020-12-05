package com.beyond.todolist.infrastructure.entity;

public class UserEntity {
    public String username;
    public String passwd;

    public UserEntity(String u, String p)
    {
        username = u; passwd = p;
    }
}
