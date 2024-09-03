package net.vrakin.med_salary.domain.mapping.department;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import net.vrakin.med_salary.domain.Department;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("MapUsers")
public class MapDepartmentUser extends MapDepartment{
    private String userId;

    public MapDepartmentUser(Long id, String departmentIsProId, Department department,
                             String userId) {
        super(id, departmentIsProId, department);
        this.userId = userId;
    }
}
