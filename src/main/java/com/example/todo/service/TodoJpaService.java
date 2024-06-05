package com.example.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.todo.repository.TodoRepository;
import com.example.todo.repository.TodoJpaRepository;
import com.example.todo.model.Todo;

// Write your code here

@Service
public class TodoJpaService implements TodoRepository {

    @Autowired
    private TodoJpaRepository tjr;

    @Override
    public ArrayList<Todo> allTodo() {
        List<Todo> all = tjr.findAll();
        ArrayList<Todo> allTodo = new ArrayList<>(all);
        return allTodo;
    }

    @Override
    public Todo eachTodo(int id) {
        try {
            Todo todo = tjr.findById(id).get();
            return todo;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Todo addTodo(Todo addto) {
        tjr.save(addto);
        return addto;
    }

    @Override
    public Todo updateTod(int id, Todo updateTo) {
        try {
            Todo update = tjr.findById(id).get();
            if (updateTo.getTodo() != null) {
                update.setTodo(updateTo.getTodo());
            }
            if (updateTo.getPriority() != null) {
                update.setPriority(update.getPriority());
            }
            if (updateTo.getStatus() != null) {
                update.setStatus(updateTo.getStatus());
            }
            tjr.save(update);
            return update;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteTodo(int id) {
        try {
            tjr.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
