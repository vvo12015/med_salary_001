package net.vrakin.med_salary.mapper;

import lombok.NoArgsConstructor;
import net.vrakin.med_salary.dto.*;
import net.vrakin.med_salary.entity.*;
import net.vrakin.med_salary.exception.ResourceNotFoundException;
import net.vrakin.med_salary.service.DepartmentService;
import net.vrakin.med_salary.service.RoleService;
import net.vrakin.med_salary.service.UserPositionService;
import net.vrakin.med_salary.service.UserService;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
@NoArgsConstructor
public abstract class UserPositionUserMapper extends AbstractMapper<User, UserDTO> {

    private UserService userService;
    private UserPositionService userPositionService;

    private UserMapper userMapper;
    private UserPositionMapper userPositionMapper;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserPositionService(UserPositionService userPositionService) {
        this.userPositionService = userPositionService;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setUserPositionMapper(UserPositionMapper userPositionMapper) {
        this.userPositionMapper = userPositionMapper;
    }

    @Mapping(target = "user", source = "user")
    @Mapping(target = "userPosition", source = "userPosition")
    public abstract UserPositionUserDTO toDto(UserPositionUser entity);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "userPosition", ignore = true)
    public abstract UserPositionUser toEntity(UserPositionUserSavedDTO dto);

    protected UserDTO map(User user) {
        return userMapper.toDto(user);
    }

    protected UserPositionDTO map(UserPosition userPosition) {
        return userPositionMapper.toDto(userPosition);
    }

    protected UserPositionUser map(UserPositionUserSavedDTO userPositionUserDTO) {
        User user = userService
                .findById(userPositionUserDTO.getUserId())
                .orElseThrow(()->
                        new ResourceNotFoundException("User", "id:", userPositionUserDTO.getUserId().toString())
                );
        UserPosition userPosition = userPositionService.findById(userPositionUserDTO.getUserPositionId())
                .orElseThrow(()->
                        new ResourceNotFoundException("UserPosition", "id:", userPositionUserDTO.getUserPositionId().toString())
                );

        UserPositionUser userPositionUser = new UserPositionUser();

        if (userPositionUserDTO.getId() != null){
            userPositionUser.setId(userPositionUserDTO.getId());
        }

        userPositionUser.setUser(user);
        userPositionUser.setUserPosition(userPosition);
        userPositionUser.setEmployment(userPositionUserDTO.getEmployment());

        return userPositionUser;
    }
}