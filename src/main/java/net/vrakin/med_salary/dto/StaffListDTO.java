package net.vrakin.med_salary.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class StaffListDTO {
    private Long id;
    private String staffListId;
    private UserPositionDTO userPosition;
    private Float employment;
    private Float maxPoint;
    private Float pointValue;
    private DepartmentDTO department;
    @Getter(onMethod_ = {@JsonGetter("IPN")})
    @Setter(onMethod_ = {@JsonSetter("IPN")})
    private String IPN;
    private LocalDate creationDate;
    private LocalDate startDate;
    private LocalDate endDate;
}
