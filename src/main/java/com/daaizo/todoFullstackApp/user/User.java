package com.daaizo.todoFullstackApp.user;

import com.daaizo.todoFullstackApp.todo.Todo;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "todo_user")
@Table(
        name = "user_table",
        uniqueConstraints = @UniqueConstraint(
                name = "user_login_unique",
                columnNames = "user_login"
        )
)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "user"
    )
    private List<Todo> todos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
