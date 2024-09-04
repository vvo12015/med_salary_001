package net.vrakin.med_salary.service.mapper;

import net.vrakin.med_salary.domain.mapping.department.MapDepartment;
import net.vrakin.med_salary.dto.MapDepartmentDTO;
import net.vrakin.med_salary.exception.ParametersMismatchException;
import net.vrakin.med_salary.repository.MapDepartmentRepository;
import net.vrakin.med_salary.service.AbstractService;
import org.mapstruct.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MapDepartmentMapperServiceImpl implements MapDepartmentMapperService {

    private MapDepartmentRepository mapDepartmentRepository;

    @Autowired
    public MapDepartmentMapperServiceImpl(MapDepartmentRepository mapDepartmentRepository) {
        this.mapDepartmentRepository = mapDepartmentRepository;
    }

    @ObjectFactory
    public MapDepartment toEntity(MapDepartmentDTO mapDepartmentDTO) {

        Map<String, String> params = new HashMap<>();

        params.put("departmentIsProId", mapDepartmentDTO.getDepartmentIsProId());

        List<MapDepartment> mapDepartments = mapDepartmentRepository
                .findByDepartmentIsProId(mapDepartmentDTO.getDepartmentIsProId());
        if (mapDepartments.size()>1){
            params.put("userId", mapDepartmentDTO.getUserId());
            return mapDepartmentRepository
                    .findByDepartmentIsProIdAndUserId(mapDepartmentDTO.getDepartmentIsProId(), mapDepartmentDTO.getUserId())
                    .orElseThrow(()->new ParametersMismatchException("MapDepartment", params));
        }else {
            return mapDepartments.stream().findFirst()
                    .orElseThrow(()->new ParametersMismatchException("MapDepartment", params));
        }
    }
}
