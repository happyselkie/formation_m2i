package org.example.ex01.controller;

import org.example.ex01.model.Todo;
import org.example.ex01.service.TodoService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/")
    public String todoList(Model model) {
        List<Todo> todos = todoService.findAll();
        model.addAttribute("todos", todos);
        return "todos";
    }

    @RequestMapping("/todo/detail")
    public String todoInfos(Model model) {
        model.addAttribute("name", "test");
        model.addAttribute("description", "test");
        model.addAttribute("isDone", "Done");
        return "person/details";
    }

}
