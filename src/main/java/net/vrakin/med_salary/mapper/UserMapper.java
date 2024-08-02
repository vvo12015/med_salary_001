package net.vrakin.med_salary.mapper;

import net.vrakin.med_salary.dto.UserDTO;
import net.vrakin.med_salary.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "departmentRef", target = "departmentName")
    @Mapping(source = "speciality", target = "specialityName")
    UserDTO mapToUserDTO(User user);

    User mapToUser(UserDTO userDTO);
}
