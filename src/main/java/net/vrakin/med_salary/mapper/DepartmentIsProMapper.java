package net.vrakin.med_salary.mapper;

import lombok.NoArgsConstructor;
import net.vrakin.med_salary.dto.DepartmentIsProDTO;
import net.vrakin.med_salary.entity.DepartmentIsProEleks;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
@NoArgsConstructor
public abstract class DepartmentIsProMapper implements BaseMapper<DepartmentIsProEleks, DepartmentIsProDTO> {

    @Override
    public abstract DepartmentIsProDTO toDto(DepartmentIsProEleks entity);

    @Override
    public abstract DepartmentIsProEleks toEntity(DepartmentIsProDTO dto);
}