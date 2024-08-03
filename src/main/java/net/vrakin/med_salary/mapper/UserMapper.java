package net.vrakin.med_salary.mapper;

import net.vrakin.med_salary.dto.RoleDTO;
import net.vrakin.med_salary.dto.UserDTO;
import net.vrakin.med_salary.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class UserMapper extends AbstractMapper<User, UserDTO> {
    @Override
    @Mapping(target = "password", ignore = true)
    @Mapping(source="department.name",  target = "departmentName")
    @Mapping(source="speciality",  target = "specialityName")
    public abstract UserDTO toDto(User entity);

    @Override
    @Mapping(source="specialityName",  target = "speciality")
    public abstract User toEntity(UserDTO dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    public abstract void updateEntityFromDto(UserDTO dto, @MappingTarget User entity);
}