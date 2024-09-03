package net.vrakin.med_salary.domain.mapping.department;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.vrakin.med_salary.domain.Department;
import org.hibernate.annotations.DiscriminatorFormula;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorFormula("case when user_id is null then 'MapDepartments' else 'MapUsers' end")
@DiscriminatorValue("MapDepartments")
public class MapDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String departmentIsProId;

    @Column
    private Department department;
}
