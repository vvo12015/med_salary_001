package net.vrakin.med_salary.service.mapper;

import net.vrakin.med_salary.dto.StaffListDTO;
import net.vrakin.med_salary.domain.mapping.users.StaffList;
import net.vrakin.med_salary.exception.IdMismatchException;
import net.vrakin.med_salary.service.*;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class StaffListMapperServiceImpl implements StaffListMapperService {

    private StaffListService staffListService;
    private UserService userService;
    private UserPositionService userPositionService;
    private DepartmentService departmentService;

    @Override
    @ObjectFactory
    public StaffList toEntity(StaffListDTO staffListDTO) {
        if (!Objects.isNull(staffListDTO.getId())){
           return staffListService.findById(staffListDTO.getId())
                   .orElseThrow(()->new IdMismatchException("StaffListDTO", staffListDTO.getStaffListId(), ""));
        }else return null;
    }
}
