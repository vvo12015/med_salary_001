package net.vrakin.med_salary.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserDTO {
    public Long id;
    public String name;
    public String login;
    public String departmentName;
    public String specialityName;
    public String isDisable;
}
