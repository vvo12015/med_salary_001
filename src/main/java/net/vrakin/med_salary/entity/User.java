package net.vrakin.med_salary.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true, nullable = false)
    private String login;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String speciality;

    @Column
    private Long departmentRef;

    @Column
    private Boolean isDisable;
}
