package net.vrakin.med_salary.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SavedDepartmentDTO {
    private String name;
    private Long managerId;
}
