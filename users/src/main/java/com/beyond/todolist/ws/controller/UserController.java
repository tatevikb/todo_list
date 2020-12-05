package com.beyond.todolist.ws.controller;

import com.beyond.todolist.converter.DtoToModel;
import com.beyond.todolist.core.model.Profession;
import com.beyond.todolist.core.model.User;
import com.beyond.todolist.infrastructure.repository.DatabaseService;
import com.beyond.todolist.ws.dto.ToDoDTO;
import com.beyond.todolist.ws.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {
    @Autowired
    private DatabaseService dbService;

    @PostMapping("/user")
    public String create(@ModelAttribute UserDTO user, Model model)
    {
        String username = (String)Storage.get("username", "");
        User yuzer = DtoToModel.convert(user);
        dbService.updateUser(username, yuzer);

        Storage.set("username", username);

        model.addAttribute("todo", new ToDoDTO());
        return "todos";
    }
}
