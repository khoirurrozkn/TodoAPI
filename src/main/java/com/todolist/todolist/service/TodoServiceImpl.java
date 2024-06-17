package com.todolist.todolist.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.todolist.todolist.model.Todo;
import com.todolist.todolist.repository.TodoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo createTodo(String text, Date date) {
        Todo todo = new Todo();
        todo.setText(text);
        todo.setDate(date);
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(Todo todo) {
        Todo findTodo = todoRepository.findById(todo.getId()).get();
        findTodo.setText(todo.getText());
        findTodo.setDate(todo.getDate());
        return todoRepository.save(findTodo);
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
    
}
