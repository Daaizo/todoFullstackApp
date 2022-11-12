package com.daaizo.todoFullstackApp.user;

import com.daaizo.todoFullstackApp.todo.Todo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "todo_user")
@Table(
        name = "user_table",
        uniqueConstraints = @UniqueConstraint(
                name = "user_login_unique",
                columnNames = "user_login"
        )
)
public class User {
    @Id
    @GeneratedValue
    @Column(
            name = "user_id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "user_name"
    )
    private String name;

    @Column(
            name = "user_login",
            nullable = false
    )
    private String login;

    @OneToMany(mappedBy = "user")
    private List<Todo> todos = new ArrayList<>();


    public User(String name, String login) {
        this.name = name;
        this.login = login;
    }

    public User(String login) {

        this.login = login;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", todos=" + todos +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


}
