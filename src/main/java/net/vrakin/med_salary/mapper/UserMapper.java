package net.vrakin.med_salary.mapper;

import lombok.NoArgsConstructor;
import net.vrakin.med_salary.dto.CreateUserDTO;
import net.vrakin.med_salary.dto.UpdateUserDTO;
import net.vrakin.med_salary.dto.UserDTO;
import net.vrakin.med_salary.entity.Department;
import net.vrakin.med_salary.entity.Role;
import net.vrakin.med_salary.entity.User;
import net.vrakin.med_salary.exception.ResourceNotFoundException;
import net.vrakin.med_salary.service.DepartmentService;
import net.vrakin.med_salary.service.RoleService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
@NoArgsConstructor
public abstract class UserMapper extends AbstractMapper<User, UserDTO> {

    private RoleService roleService;
    private DepartmentService departmentService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "department", source = "department")
    public abstract UserDTO toDto(User entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "department", ignore = true)
    @Mapping(target = "roles", ignore = true)
    public abstract User toEntity(CreateUserDTO dto);

    @Mapping(target = "department", ignore = true)
    @Mapping(target = "roles", ignore = true)
    public abstract User toEntity(UpdateUserDTO dto);

    @AfterMapping
    protected void linkDepartmentAndRoles(CreateUserDTO userDTO, @MappingTarget User user) {

        Long departmentId = userDTO.getDepartmentId();
        List<Long> roleIds = userDTO.getRoleIds();

        if (departmentId != null) {
            Department department = departmentService.findById(departmentId)
                    .orElseThrow(() -> new ResourceNotFoundException("Department", "id", departmentId.toString()));
            user.setDepartment(department);
        }

        if (roleIds != null && !roleIds.isEmpty()) {
            user.setRoles(roleService.findAllById(roleIds));
        }
    }

    @AfterMapping
    protected void linkDepartmentAndRoles(UpdateUserDTO userDTO, @MappingTarget User user) {

        Long departmentId = userDTO.getDepartmentId();
        List<Long> roleIds = userDTO.getRoleIds();

        if (departmentId != null) {
            Department department = departmentService.findById(departmentId)
                    .orElseThrow(() -> new ResourceNotFoundException("Department", "id", departmentId.toString()));
            user.setDepartment(department);
        }

        if (roleIds != null && !roleIds.isEmpty()) {
            List<Role> roles = roleService.findAllById(roleIds);
            user.setRoles(roles);
        }
    }

    protected List<Long> map(List<Role> roles) {
        return roles == null ? null : roles.stream().map(Role::getId).collect(Collectors.toList());
    }

}