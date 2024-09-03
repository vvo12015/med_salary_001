package net.vrakin.med_salary.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class MapDepartmentDTO {
    private Long id;
    private String name;
    private String departmentIsProId;
    private String userId;
}
