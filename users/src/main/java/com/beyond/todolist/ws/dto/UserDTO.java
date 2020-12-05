package com.beyond.todolist.ws.dto;

import lombok.Data;

@Data
public class UserDTO {
    public int id;
    public String firstName;
    public String lastName;
    public String email;
    public double salary;
    public String birthday;
    public int gender;
    public String profession;
}
