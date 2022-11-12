package com.daaizo.todoFullstackApp;

import com.daaizo.todoFullstackApp.todo.Todo;
import com.daaizo.todoFullstackApp.todo.TodoRepository;
import com.daaizo.todoFullstackApp.user.User;
import com.daaizo.todoFullstackApp.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TodoFullstackAppApplicationTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TodoRepository todoRepository;

    @Test
    void saveUser() {
        User u1 = new User("daaizo1");
        userRepository.save(u1);

    }

    @Test
    void saveTodo() {
        Todo t1 = new Todo("eat cereals", "maybe with milk");
        todoRepository.save(t1);
    }

    @Test
    void saveTodoToUser() {
        Todo t1 = new Todo("wash dishes");
        todoRepository.save(t1);
        User u1 = new User("cat12");
        userRepository.save(u1);
        t1.setUser(u1);
        todoRepository.save(t1);
    }

    @Test
    void saveTodoToUserWithoutTodoCreated() {
        User u1 = new User("cat12");
        u1.setTodos(List.of(
                new Todo("wash dishes"),
                new Todo("clean room")
        ));
        userRepository.save(u1);
    }

    @Test
    void getPrintAllUserTodosByUserLogin() {
        List<Todo> todoList = todoRepository.findAllByUser_login("cat12");
        System.out.println("todoList = " + todoList);
    }

    @Test
    void getPrintAllUsers() {
        Iterable<User> userList = userRepository.findAll();
        System.out.println("userList = " + userList);

    }

    @Test
    void getPrintAllTodos() {
        Iterable<Todo> todosList = todoRepository.findAll();
        System.out.println("todosList = " + todosList);
    }


}