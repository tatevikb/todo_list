package com.beyond.todolist.ws.controller;

import com.beyond.todolist.infrastructure.entity.UserEntity;
import com.beyond.todolist.infrastructure.repository.DatabaseService;
import com.beyond.todolist.infrastructure.repository.UserRepository;
import com.beyond.todolist.utils.HashUtil;
import com.beyond.todolist.ws.dto.Credentials;
import com.beyond.todolist.ws.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomePageController {
    @Autowired
    private DatabaseService dbService;

    @GetMapping("/")
    public String homePage(Model model)
    {
        model.addAttribute("creds", new Credentials());
        return "home";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute Credentials creds, Model model)
    {
        String view = "";

        if( dbService.userExists(creds.username) ) {
            // TODO:
            view = "userExists";
        }
        else {
            int userId = dbService.createUser(creds.username, HashUtil.calculate(creds.password));
            // TODO: List<Profession> profs = dbService.getProfessions();
            Storage.set("userId", userId);
            Storage.set("username", creds.username);
            model.addAttribute("user", new UserDTO());
            view = "create";
        }

        return view;
    }

    @PostMapping("/login")
    public String logInUser(@ModelAttribute Credentials creds, Model model)
    {
        //model.addAttribute("user", new User());
        return "login"; // TODO: change this
    }
}
