package net.vrakin.med_salary.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
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

    @Column(name = "speciality")
    private String specialityName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_ref")
    private Department department;

    @Column
    private Boolean isDisable;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user_position_user")
    List<UserPositionUser> userPositionUserList;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", specialityName='" + specialityName + '\'' +
                ", department=" + department +
                ", isDisable=" + isDisable +
                '}';
    }
}
