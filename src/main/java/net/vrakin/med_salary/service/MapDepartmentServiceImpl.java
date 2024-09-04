package net.vrakin.med_salary.service;

import net.vrakin.med_salary.domain.mapping.department.MapDepartment;
import net.vrakin.med_salary.domain.mapping.department.MapDepartmentUser;
import net.vrakin.med_salary.dto.MapDepartmentDTO;
import net.vrakin.med_salary.exception.ParametersMismatchException;
import net.vrakin.med_salary.repository.MapDepartmentRepository;
import net.vrakin.med_salary.service.mapper.MapDepartmentMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MapDepartmentServiceImpl extends AbstractService<MapDepartment> implements MapDepartmentService {

    private MapDepartmentRepository mapDepartmentRepository;

    @Autowired
    public MapDepartmentServiceImpl(MapDepartmentRepository mapDepartmentRepository) {
        super(mapDepartmentRepository);
        this.mapDepartmentRepository = mapDepartmentRepository;
    }

    public Optional<MapDepartmentUser> findByDepartmentIsProIdAndUserId(String departmentIsProId,
                                                                        String userId){
        return mapDepartmentRepository.findByDepartmentIsProIdAndUserId(departmentIsProId, userId);
    }
}
