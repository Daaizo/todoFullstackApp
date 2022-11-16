package com.daaizo.todoFullstackApp.todo;

import com.daaizo.todoFullstackApp.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TodoRepositoryTest {


    @Autowired
    TodoRepository todoRepository;

    @Test
    void saveTodo() {
        Todo t1 = Todo.builder()
                .name("maybe with milk").
                text("some text")
                .build();
        todoRepository.save(t1);

    }

    @Test
    void saveTodoToNewUser() {
        Todo t1 = Todo.builder().
                name("eat").
                build();
        t1.setUser(User.builder().name("Daniel").build());
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