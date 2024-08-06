package net.vrakin.med_salary.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SecurityUserSavedDTO {
    private Long id;
    private String login;
    private String password;
    private String securityRole;
}
