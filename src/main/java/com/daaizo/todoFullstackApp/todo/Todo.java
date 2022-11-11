package com.daaizo.todoFullstackApp.todo;

import com.daaizo.todoFullstackApp.user.User;

import javax.persistence.*;

@Table(
        name = "todo_table"
)
@Entity
public class Todo {
    @Id
    @GeneratedValue
    @Column(
            updatable = false
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_user_id")
    private User user;

    @Column(
            name = "todo_name",
            nullable = false
    )
    private String name;

    @Column(
            name = "todo_text"
    )
    private String text;

    @Column(
            name = "todo_date"
    )
    private String date;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Todo() {

    }

    public Todo(String name, String text, String date) {
        this.name = name;
        this.text = text;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
