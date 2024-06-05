package com.example.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.todo.service.TodoJpaService;
import com.example.todo.model.Todo;

// Write your code here
@RestController
public class TodoController {
    @Autowired
    public TodoJpaService tjs;

    @GetMapping("/todos")
    public ArrayList<Todo> allTodo() {
        return tjs.allTodo();
    }

    @GetMapping("/todos/{id}")
    public Todo eachTodo(@PathVariable("id") int id) {
        return tjs.eachTodo(id);
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo addto) {
        return tjs.addTodo(addto);
    }

    @PutMapping("/todos/{id}")
    public Todo updateTod(@PathVariable("id") int id, @RequestBody Todo updateTo) {
        return tjs.updateTod(id, updateTo);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable("id") int id) {
        tjs.deleteTodo(id);
    }
}
