package net.vrakin.med_salary.domain.mapping.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("MapUser")
public class MapUser extends AbstractUser {

    @ManyToMany
    @JoinTable(
            name = "users_eleks",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "eleks_id"))
    List<UserEleks> userEleksList;
    @ManyToMany
    @JoinTable(
            name = "users_staff",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "staff_id"))
    List<StaffList> staffs;
}
