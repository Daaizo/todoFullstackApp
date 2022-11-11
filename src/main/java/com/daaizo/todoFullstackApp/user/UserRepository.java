package com.daaizo.todoFullstackApp.user;

import com.daaizo.todoFullstackApp.todo.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<Todo> findAllByTodos_name(String name);
}
