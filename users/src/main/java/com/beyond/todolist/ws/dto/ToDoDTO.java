package com.beyond.todolist.ws.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ToDoDTO {
    public int userId;
    public String description;
    public String status;
    public boolean isDeleted; // ?
}
