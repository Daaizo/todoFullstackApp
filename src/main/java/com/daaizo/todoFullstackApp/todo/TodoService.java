package com.daaizo.todoFullstackApp.todo;

import com.daaizo.todoFullstackApp.user.User;
import com.daaizo.todoFullstackApp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    final
    TodoRepository todoRepository;
    final
    UserRepository userRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository, UserRepository userRepository) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }

    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    public void addTodo(Todo todo, Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new IllegalStateException("There is no user with such an id");
        }
        todo.setUser(user.get());
        todoRepository.save(todo);
    }


    public void deleteTodo(Long id) {
        checkIfTodoExist(id);
        todoRepository.deleteById(id);
    }


    Todo checkIfTodoExist(Long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isEmpty()) {
            throw new IllegalStateException("todo with id = " + id + " does not exists");
        }
        return todo.get();
    }

    @Transactional
    public void updateTodo(Long id, String newName, String newText) {
        Todo todo = checkIfTodoExist(id);
        if (newName != null && !newName.equals(todo.getName())) {
            todo.setName(newName);
        }
        if (newText != null && !newText.equals(todo.getText())) {
            todo.setText(newText);
        }
    }
}
