package net.vrakin.med_salary.domain;

import jakarta.persistence.*;
import lombok.*;
import net.vrakin.med_salary.domain.mapping.users.User;
import net.vrakin.med_salary.domain.mapping.users.UserEleks;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private List<User> users;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_ref")
    private UserEleks manager;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manager='" + manager.getName() + '\'' +
                '}';
    }
}
