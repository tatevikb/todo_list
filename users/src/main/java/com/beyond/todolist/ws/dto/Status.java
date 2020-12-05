package com.beyond.todolist.ws.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Status {
    private int id;
    private Status status;
}
