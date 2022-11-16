package com.daaizo.todoFullstackApp.user;

import com.daaizo.todoFullstackApp.todo.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;


    @Test
    void saveUser() {
        User u1 = User.builder().
                name("daniel").
                login("daaizo123").
                build();
        userRepository.save(u1);

    }


    @Test
    void saveTodoToUser() {

        User u1 = User.builder().
                name("kuba").
                login("jacob2").
                build();
        u1.setTodos(List.of(
                Todo.builder().
                        name("play games").
                        user(u1).
                        build(),
                Todo.builder().
                        name("do homework").
                        user(u1).
                        build()
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