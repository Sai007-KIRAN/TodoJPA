package com.example.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.todo.model.Todo;

// Write your code here
@Repository
public interface TodoJpaRepository extends JpaRepository<Todo, Integer> {

}
