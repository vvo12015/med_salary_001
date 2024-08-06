package net.vrakin.med_salary.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserSavedDTO {
    private Long id;
    private String name;
    private String login;
    private String password;
    private String specialityName;
    private Long departmentId;
    private List<Long> roleIds;
    private String isDisable;
}
