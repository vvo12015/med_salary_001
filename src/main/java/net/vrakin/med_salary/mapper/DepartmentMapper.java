package net.vrakin.med_salary.mapper;

import lombok.NoArgsConstructor;
import net.vrakin.med_salary.dto.DepartmentDTO;
import net.vrakin.med_salary.dto.RoleDTO;
import net.vrakin.med_salary.dto.SavedDepartmentDTO;
import net.vrakin.med_salary.dto.UserDTO;
import net.vrakin.med_salary.entity.Department;
import net.vrakin.med_salary.entity.Role;
import net.vrakin.med_salary.entity.User;
import net.vrakin.med_salary.exception.ResourceNotFoundException;
import net.vrakin.med_salary.service.UserService;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
@NoArgsConstructor
public abstract class DepartmentMapper extends AbstractMapper<Department, DepartmentDTO> {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }
    @Override
    @Mapping(target = "manager", source = "manager")
    public abstract DepartmentDTO toDto(Department entity);

    @Override
    @Mapping(target = "manager", ignore = true)
    public abstract Department toEntity(DepartmentDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "manager", ignore = true)
    public abstract Department toEntity(SavedDepartmentDTO dto);

    @AfterMapping
    protected void likeManager(DepartmentDTO departmentDTO, @MappingTarget Department department){
        Long managerId = departmentDTO.getManager().getId();

        if (managerId != null) {
            User manager = userService.findById(managerId)
                    .orElseThrow(() -> new ResourceNotFoundException("Manager", "id", managerId.toString()));
            department.setManager(manager);
        }
    }


}