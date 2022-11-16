package com.daaizo.todoFullstackApp.todo;

import com.daaizo.todoFullstackApp.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Table(
        name = "todo_table"
)
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
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
            referencedColumnName = "USER_ID",
            nullable = false
    )
    @ToString.Exclude
    private User user;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Todo todo = (Todo) o;
        return id != null && Objects.equals(id, todo.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
