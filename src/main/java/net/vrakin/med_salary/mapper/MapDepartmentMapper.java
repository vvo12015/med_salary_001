package net.vrakin.med_salary.mapper;

import lombok.NoArgsConstructor;
import net.vrakin.med_salary.domain.mapping.department.MapDepartment;
import net.vrakin.med_salary.dto.MapDepartmentDTO;
import net.vrakin.med_salary.service.mapper.MapDepartmentMapperService;
import org.mapstruct.Mapper;

@Mapper(uses = {MapDepartmentMapperService.class})
@NoArgsConstructor
public abstract class MapDepartmentMapper implements BaseMapper<MapDepartment, MapDepartmentDTO> {

    @Override
    public abstract MapDepartmentDTO toDto(MapDepartment entity);

    @Override
    public abstract MapDepartment toEntity(MapDepartmentDTO dto);
}