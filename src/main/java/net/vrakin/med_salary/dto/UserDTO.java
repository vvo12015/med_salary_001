package net.vrakin.med_salary.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserDTO {
    private Long id;
    private String name;
    private String login;
    private DepartmentDTO department;
    private String specialityName;
    private String isDisable;
    private String password;
    private List<RoleDTO> roles;
}
