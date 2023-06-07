package com.burakbayramin.controller;

import com.burakbayramin.model.Todos;
import com.burakbayramin.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoFormController {

    private final TodoService todoService;

    public TodoFormController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("create-todo")
    public String showForm(Todos todos) {
        return "new-todo";
    }

    @PostMapping("/todo")
    public String createTodo(@Valid Todos todos, BindingResult result, Model model) {

        Todos val = new Todos();
        val.setDescription(todos.getDescription());
        val.setIsComplete(todos.getIsComplete());

        todoService.save(todos);
        return "redirect:/";

    }

}
