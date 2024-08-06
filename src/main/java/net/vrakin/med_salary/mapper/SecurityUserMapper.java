package net.vrakin.med_salary.mapper;

import net.vrakin.med_salary.dto.SecurityUserDTO;
import net.vrakin.med_salary.dto.SecurityUserSavedDTO;
import net.vrakin.med_salary.entity.SecurityUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class SecurityUserMapper extends AbstractMapper<SecurityUser, SecurityUserDTO> {
    @Override
    public abstract SecurityUserDTO toDto(SecurityUser entity);

    @Override
    public abstract SecurityUser toEntity(SecurityUserDTO dto);

    @Mapping(target = "id", ignore = true)
    public abstract SecurityUser toEntity(SecurityUserSavedDTO dto);


}