package net.vrakin.med_salary.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserPositionUserDTO {
    private Long id;
    private UserPositionDTO userPositionDTO;
    private UserDTO userDTO;
    private Float employment;
}
