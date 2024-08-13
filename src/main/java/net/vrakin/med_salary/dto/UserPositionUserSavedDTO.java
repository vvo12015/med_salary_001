package net.vrakin.med_salary.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserPositionUserSavedDTO {
    private Long id;
    private Long userPositionId;
    private Long userId;
    private Float employment;
}
