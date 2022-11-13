package com.daaizo.todoFullstackApp.todo;

import com.daaizo.todoFullstackApp.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Table(
        name = "todo_table"
)
@Entity
public class Todo {
    @Id
    @GeneratedValue
    @Column(
            name = "todo_id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "todo_name",
            nullable = false
    )
    private String name;

    @Column(
            name = "todo_text"
    )
    private String text;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(
            name = "todo_date"
    )
    private Date dateTime;

    @JsonIgnore
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST
    )
    @JoinColumn(
            name = "USER_ID",
            referencedColumnName = "USER_ID"
//            ,
//            nullable = false
    )
    private User user;

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }

    public Todo(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public Todo(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Todo() {

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateTime() {
        Date date;
        return dateTime;
    }

}
