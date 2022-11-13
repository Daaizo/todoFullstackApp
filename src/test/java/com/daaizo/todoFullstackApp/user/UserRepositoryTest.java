package com.daaizo.todoFullstackApp.user;

import com.daaizo.todoFullstackApp.todo.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;


    @Test
    void saveUser() {
        User u1 = new User("daaizo1");
        userRepository.save(u1);

    }


    @Test
    void saveTodoToUser() {

        User u1 = new User("cat12");
        u1.setTodos(List.of(
                new Todo("eat"),
                new Todo("sleep")
        ));
        userRepository.save(u1);

    }

    @Test
    void saveTodoToUserWithoutTodoCreated() {
        ///todo -> user id is not added, and it should be not added
        User u1 = new User("a21");
        u1.setTodos(List.of(
                new Todo("wash dishes"),
                new Todo("clean room")
        ));
        userRepository.save(u1);
    }


    @Test
    void getPrintAllUsers() {
        Iterable<User> userList = userRepository.findAll();
        System.out.println("userList = " + userList);

    }

    @Test
    void getPrintUserByLogin() {
        Optional<User> userList = userRepository.findUserByLogin("daaizo");
        System.out.println("userList = " + userList);
    }
}