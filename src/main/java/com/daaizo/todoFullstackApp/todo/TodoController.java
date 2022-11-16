package com.daaizo.todoFullstackApp.todo;

import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping(path = "/add")
    public void addTodo(@RequestBody Todo todo, @RequestBody Long userId) {
        //todo add todo ONLY with user
        todoService.addTodo(todo, userId);
    }

    @DeleteMapping(path = "/delete/{id}")
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

