package net.vrakin.med_salary.mapper;

import lombok.NoArgsConstructor;
import net.vrakin.med_salary.dto.MapDepartmentDTO;
import net.vrakin.med_salary.domain.DepartmentIsProEleks;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
@NoArgsConstructor
public abstract class DepartmentIsProMapper implements BaseMapper<DepartmentIsProEleks, MapDepartmentDTO> {

    @Override
    public abstract MapDepartmentDTO toDto(DepartmentIsProEleks entity);

    @Override
    public abstract DepartmentIsProEleks toEntity(MapDepartmentDTO dto);
}