package net.vrakin.med_salary.domain.mapping.users;

import jakarta.persistence.*;
import lombok.*;


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
        return "UserEleks{" +
                ", login='" + login + '\'' +
                '}';
    }
}
