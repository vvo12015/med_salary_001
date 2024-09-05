package net.vrakin.med_salary.mapper;

import lombok.NoArgsConstructor;
import net.vrakin.med_salary.dto.DepartmentDTO;
import net.vrakin.med_salary.dto.DepartmentSavedDTO;
import net.vrakin.med_salary.domain.Department;
import net.vrakin.med_salary.domain.mapping.users.User;
import net.vrakin.med_salary.exception.ResourceNotFoundException;
import net.vrakin.med_salary.service.UserService;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
@NoArgsConstructor
public abstract class DepartmentMapper implements BaseMapper<Department, DepartmentDTO> {

    @Override
    @Mapping(target = "managerName", source = "manager.name")
    public abstract DepartmentDTO toDto(Department entity);

    @Override
    @Mapping(target = "manager", ignore = true)
    public abstract Department toEntity(DepartmentDTO dto);

    @Mapping(target = "manager", ignore = true)
    public abstract Department toEntity(DepartmentSavedDTO dto);
}