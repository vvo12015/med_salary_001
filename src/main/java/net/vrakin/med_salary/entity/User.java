package net.vrakin.med_salary.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private Long id;

    @Column(unique=true)
    private String login;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String speciality;

    @Column(name = "department_ref")
    private Long departmentRef;

    @Column(name = "is_disable", columnDefinition = "BOOLEAN")
    private Boolean isDisable;
}
