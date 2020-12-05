package com.beyond.todolist.converter;

import com.beyond.todolist.core.model.Gender;
import com.beyond.todolist.core.model.Profession;
import com.beyond.todolist.core.model.ToDo;
import com.beyond.todolist.core.model.User;
import com.beyond.todolist.ws.dto.ToDoDTO;
import com.beyond.todolist.ws.dto.UserDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DtoToModel {
    public static User convert(UserDTO user)
    {
        User muser = new User();
        muser.firstName = user.firstName;
        muser.lastName = user.lastName;
        muser.email = user.email;
        muser.gender = user.gender == 1 ? Gender.MALE : Gender.FEMALE;
        muser.profession = new Profession(user.profession);
        try {
            muser.birthday = new SimpleDateFormat("yyyy-MM-dd").parse(user.birthday);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        muser.salary = user.salary;
        return muser;
    }

    public static ToDo convert(ToDoDTO user)
    {
        ToDo mToDo = new ToDo();
        mToDo.userId = user.userId;
        mToDo.description = user.description;
        mToDo.statusId = Integer.parseInt(user.status);
        mToDo.isDeleted = user.isDeleted;
        return mToDo;
    }
    //divide
}
