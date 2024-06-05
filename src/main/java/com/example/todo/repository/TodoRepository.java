// Write your code here

package com.example.todo.repository;

import java.util.*;
import com.example.todo.model.Todo;

public interface TodoRepository {
    ArrayList<Todo> allTodo();

    Todo eachTodo(int id);

    Todo addTodo(Todo addto);

    Todo updateTod(int id, Todo updateTo);

    void deleteTodo(int id);
}