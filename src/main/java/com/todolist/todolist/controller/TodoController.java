package com.todolist.todolist.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.todolist.model.Todo;
import com.todolist.todolist.service.TodoService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/todo")
public class TodoController {
    
    private TodoService todoService;

    @GetMapping
    public ResponseEntity<List<Todo>> findAllTodo(){
        List<Todo> todos = todoService.findAll();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Todo> newTodo(@RequestBody Todo todo) {
        Todo createdTodo = todoService.createTodo(todo.getText(), todo.getDate());
        return new ResponseEntity<>(createdTodo, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") Long todoId, @RequestBody Todo todo) {
      todo.setId(todoId);
      Todo updateTodo = todoService.updateTodo(todo);
      return new ResponseEntity<>(updateTodo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodoById(@PathVariable("id") Long todoId){
        todoService.deleteTodo(todoId);
        return new ResponseEntity<>("Todo has been deleted", HttpStatus.OK);
    }

}
