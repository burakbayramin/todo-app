package com.burakbayramin.service;

import com.burakbayramin.model.Todos;
import com.burakbayramin.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Iterable<Todos> getAll() {
        return todoRepository.findAll();
    }

    public Todos save(Todos todos) {
        if (todos.getId() == null) {
            todos.setCreatedAt(Instant.now());
        }
        todos.setUpdatedAt(Instant.now());
        return todoRepository.save(todos);
    }

    public void delete(Todos todos) {
        todoRepository.delete(todos);
    }

    public Optional<Todos> getById(Long id) {
        return todoRepository.findById(id);
    }
}
