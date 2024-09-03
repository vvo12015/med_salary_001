package net.vrakin.med_salary.mapper;

import net.vrakin.med_salary.dto.RoleDTO;
import net.vrakin.med_salary.dto.RoleSavedDTO;
import net.vrakin.med_salary.domain.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class RoleMapper implements BaseMapper<Role, RoleDTO> {
    @Override
    public abstract RoleDTO toDto(Role entity);

    @Override
    public abstract Role toEntity(RoleDTO dto);

    @Mapping(target = "id", ignore = true)
    public abstract Role toEntity(RoleSavedDTO dto);
}