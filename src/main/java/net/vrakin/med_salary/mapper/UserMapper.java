package net.vrakin.med_salary.mapper;

import lombok.NoArgsConstructor;
import net.vrakin.med_salary.dto.DepartmentDTO;
import net.vrakin.med_salary.dto.UserSavedDTO;
import net.vrakin.med_salary.dto.UserDTO;
import net.vrakin.med_salary.domain.Department;
import net.vrakin.med_salary.domain.Role;
import net.vrakin.med_salary.domain.mapping.users.User;
import net.vrakin.med_salary.exception.ResourceNotFoundException;
import net.vrakin.med_salary.service.DepartmentService;
import net.vrakin.med_salary.service.RoleService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
@NoArgsConstructor
public abstract class UserMapper implements BaseMapper<User, UserDTO> {

    private RoleService roleService;
    private DepartmentService departmentService;

    private DepartmentMapper departmentMapper;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Autowired
    public void setDepartmentMapper(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "department", source = "department")
    public abstract UserDTO toDto(User entity);

    @Mapping(target = "department", ignore = true)
    @Mapping(target = "roles", ignore = true)
    public abstract User toEntity(UserSavedDTO dto);


    @AfterMapping
    protected void linkDepartmentAndRoles(UserSavedDTO userDTO, @MappingTarget User user) {

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

    protected DepartmentDTO map(Department department){
        return departmentMapper.toDto(department);
    }

}