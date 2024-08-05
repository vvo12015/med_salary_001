package net.vrakin.med_salary.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UpdatedDepartmentDTO {
    private Long id;
    private String name;
    private Long managerId;
}
