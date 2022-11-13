package com.daaizo.todoFullstackApp.todo;

import com.daaizo.todoFullstackApp.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/todos")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    @GetMapping(path = "/all")
    List<Todo> getTodos() {
        return todoService.getTodos();
    }

    @PostMapping
    public void addTodo(@RequestBody Todo todo) {
        //todo add todo ONLY with user
        todoService.addTodo(todo);
    }

    @DeleteMapping(path = "{id}")
    public void deleteTodo(
            @PathVariable("id") Long id
    ) {
        todoService.deleteTodo(id);
    }

    @PutMapping(path = "{id}")
    public void updateTodo(
            @PathVariable Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String text
    ) {
        todoService.updateTodo(id, name, text);
    }
}

