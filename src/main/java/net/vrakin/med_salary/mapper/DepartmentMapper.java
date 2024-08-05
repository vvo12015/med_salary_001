package net.vrakin.med_salary.mapper;

import net.vrakin.med_salary.dto.DepartmentDTO;
import net.vrakin.med_salary.dto.RoleDTO;
import net.vrakin.med_salary.dto.SavedDepartmentDTO;
import net.vrakin.med_salary.entity.Department;
import net.vrakin.med_salary.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class DepartmentMapper extends AbstractMapper<Department, DepartmentDTO> {
    @Override
    public abstract DepartmentDTO toDto(Department entity);

    @Override
    public abstract Department toEntity(DepartmentDTO dto);

    @Mapping(target = "id", ignore = true)
    public abstract Department toEntity(SavedDepartmentDTO dto);
}