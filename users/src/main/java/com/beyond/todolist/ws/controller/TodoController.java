package com.beyond.todolist.ws.controller;

import com.beyond.todolist.converter.DtoToModel;
import com.beyond.todolist.converter.ModelToDto;
import com.beyond.todolist.core.model.ToDo;
import com.beyond.todolist.infrastructure.repository.DatabaseService;
import com.beyond.todolist.ws.dto.ToDoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TodoController {
    @Autowired
    private DatabaseService dbService;

    @PostMapping("/addTodo")
    public String addTodo(@ModelAttribute ToDoDTO todo, Model model)
    {
        String username = (String)Storage.get("username", "");
        int userId = (Integer)Storage.get("userId", 0);
        todo.userId = userId;
        ToDo mtodo = DtoToModel.convert(todo);
        dbService.addTodo(mtodo);

//        List<ToDo> todos = dbService.getAllTodos(username);
//        List<ToDoDTO> todosdto = new ArrayList<>();
//        for(ToDo e : todos) {
//            todosdto.add(ModelToDto.convert(e));
//        }
//        model.addAttribute("todoList", todosdto);

        //model.addAttribute("todo", new ToDoDTO());
        return "todos";
    }
}
