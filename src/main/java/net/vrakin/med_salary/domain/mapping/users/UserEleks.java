package net.vrakin.med_salary.domain.mapping.users;

import jakarta.persistence.*;
import lombok.*;
import net.vrakin.med_salary.domain.Department;
import net.vrakin.med_salary.domain.Role;
import net.vrakin.med_salary.domain.StaffList;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("UserEleks")
public class UserEleks extends AbstractUser{
    @Column(unique=true, nullable = false)
    private String login;

    @Override
    public String toString() {
        return "User{" +
                ", login='" + login + '\'' +
                '}';
    }
}
