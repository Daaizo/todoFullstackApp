package com.daaizo.todoFullstackApp;


import com.daaizo.todoFullstackApp.todo.Todo;
import com.daaizo.todoFullstackApp.todo.TodoRepository;
import com.daaizo.todoFullstackApp.user.User;
import com.daaizo.todoFullstackApp.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class TodoFullstackAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoFullstackAppApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(TodoRepository todoRepository, UserRepository userRepository) {
        return (arg -> {
            testObjectCreation(todoRepository, userRepository);
            System.out.println("wszystkie todo z nazwa " + userRepository.findAllByTodos_name("todo2"));
            System.out.println("wszystkie todo uzytkownika daniel " + todoRepository.findAllByUser_Name("Daniel"));

        });
    }

    void testObjectCreation(TodoRepository todoRepository, UserRepository userRepository) {
        User u1 = new User("Daniel");
        User u2 = new User("Kuba");
        User u3 = new User("Jacek");
        Todo t1 = new Todo("todos2", "", "12");
        Todo t2 = new Todo("todos3", "", "12");

        todoRepository.saveAll(List.of(t1, t2));
        userRepository.saveAll(List.of(u1, u2, u3));
        System.out.println(todoRepository.findAll());
        System.out.println(userRepository.findAll());

        t1.setUser(u1);
        t2.setUser(u1);
        todoRepository.saveAll(List.of(t1, t2));
    }
}
