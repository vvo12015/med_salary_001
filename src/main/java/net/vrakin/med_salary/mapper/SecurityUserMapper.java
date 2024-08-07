package net.vrakin.med_salary.mapper;

import net.vrakin.med_salary.dto.SecurityUserDTO;
import net.vrakin.med_salary.entity.SecurityUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class SecurityUserMapper extends AbstractMapper<SecurityUser, SecurityUserDTO> {
    @Override
    @Mapping(target = "password", ignore = true)
    public abstract SecurityUserDTO toDto(SecurityUser entity);

    @Override
    public abstract SecurityUser toEntity(SecurityUserDTO dto);

}