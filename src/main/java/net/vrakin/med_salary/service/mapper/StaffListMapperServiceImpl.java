package net.vrakin.med_salary.service.mapper;

import net.vrakin.med_salary.dto.StaffListDTO;
import net.vrakin.med_salary.domain.StaffList;
import net.vrakin.med_salary.exception.ResourceNotFoundException;
import net.vrakin.med_salary.service.*;
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
    public Optional<StaffList> mappedToEntity(StaffListDTO staffListDTO) {
        StaffList staffList = new StaffList();
        if (!Objects.isNull(staffListDTO.getId())){
           return staffListService.findById(staffListDTO.getId());
        }
        staffList.setStaffListId(staffListDTO.getStaffListId());
        Long userId = staffListDTO.getUser().getId();
        staffList.setUser(userService.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("StaffListDTO", "userId", userId.toString())));
        Long userPositionId = staffListDTO.getUserPosition().getId();
        staffList.setUserPosition(userPositionService.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("StaffListDTO", "userPositionId", userPositionId.toString())));
        staffList.setEmployment(staffListDTO.getEmployment());
        staffList.setMaxPoint(staffListDTO.getMaxPoint());
        staffList.setPointValue(staffListDTO.getPointValue());
        Long departmentId = staffListDTO.getDepartment().getId();
        staffList.setDepartment(departmentService.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("StaffListDTO", "departmentId", departmentId.toString())));
        staffList.setIPN(staffListDTO.getIPN());
        staffList.setCreationDate(staffListDTO.getCreationDate());
        staffList.setStartDate(staffListDTO.getStartDate());
        staffList.setStaffListId(staffListDTO.getStaffListId());

        return Optional.of(staffList);
    }
}
