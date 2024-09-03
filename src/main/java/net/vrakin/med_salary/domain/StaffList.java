package net.vrakin.med_salary.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.*;
import lombok.*;
import net.vrakin.med_salary.domain.mapping.department.MapDepartment;
import net.vrakin.med_salary.domain.mapping.department.MapDepartmentUser;
import net.vrakin.med_salary.domain.mapping.users.AbstractUser;

import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("StaffList")
public class StaffList extends AbstractUser {
    @Column
    private String staffListId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_position_id")
    private UserPosition userPosition;

    @Column
    private Float employment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;

    @Override
    public String toString() {
        return "StaffList{" +
                "id=" + super.getId() +
                ", staffListId='" + staffListId + '\'' +
                ", userPosition=" + (Objects.isNull(userPosition.getName())?userPosition.getName():"userPosition is empty") +
                ", employment=" + employment +
                ", IPN='" + super.getIPN() + '\'' +
                '}';
    }
}
