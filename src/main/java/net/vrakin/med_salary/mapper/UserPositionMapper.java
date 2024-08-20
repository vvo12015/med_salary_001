package net.vrakin.med_salary.mapper;

import net.vrakin.med_salary.dto.UserPositionDTO;
import net.vrakin.med_salary.entity.UserPosition;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserPositionMapper implements BaseMapper<UserPosition, UserPositionDTO> {
    @Override
    public abstract UserPositionDTO toDto(UserPosition entity);

    @Override
    public abstract UserPosition toEntity(UserPositionDTO dto);
}