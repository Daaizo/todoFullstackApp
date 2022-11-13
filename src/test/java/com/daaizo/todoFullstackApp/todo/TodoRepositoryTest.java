package com.daaizo.todoFullstackApp.todo;

import com.daaizo.todoFullstackApp.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TodoRepositoryTest {


    @Autowired
    TodoRepository todoRepository;

    @Test
    void saveTodo() {
        Todo t1 = new Todo("eat cereals", "maybe with milk");

        todoRepository.save(t1);

    }

    @Test
    void saveTodoToNewUser() {
        Todo t1 = new Todo("eat");
        t1.setUser(new User("daa12"));
        todoRepository.save(t1);
    }

    @Test
    void getPrintAllTodos() {
        Iterable<Todo> todosList = todoRepository.findAll();
        System.out.println("todosList = " + todosList);
    }

    @Test
    void getPrintAllUserTodosByUserLogin() {
        List<Todo> todoList = todoRepository.findAllByUser_login("cat12");
        System.out.println("todoList = " + todoList);
    }


}