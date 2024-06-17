package com.todolist.todolist.service;

import java.util.Date;
import java.util.List;

import com.todolist.todolist.model.Todo;

public interface TodoService {
    List<Todo> findAll();
    Todo createTodo(String text, Date date);
    Todo updateTodo(Todo todo);
    void deleteTodo(Long id);
}
