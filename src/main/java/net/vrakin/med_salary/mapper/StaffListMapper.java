package net.vrakin.med_salary.mapper;

import lombok.extern.slf4j.Slf4j;
import net.vrakin.med_salary.dto.*;
import net.vrakin.med_salary.domain.mapping.users.StaffList;
import net.vrakin.med_salary.excel.ExcelHelper;
import net.vrakin.med_salary.service.mapper.StaffListMapperService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Mapper(uses = StaffListMapperService.class)
public abstract class StaffListMapper implements BaseMapper<StaffList, StaffListDTO> {
    public static final int INDEX_STAFF_LIST_ID = 0;
    public static final int INDEX_USER_POSITION_CODE = 1;
    public static final int INDEX_USER_POSITION_NAME = 2;
    public static final int INDEX_DEPARTMENT_NAME = 3;
    public static final int INDEX_EMPLOYMENT = 4;
    public static final int INDEX_IPN = 5;
    public static final int INDEX_DEPARTMENT_CODE = 6;
    private ExcelHelper excelHelper;

    @Mapping(target = "IPN", source = "IPN")
    public abstract StaffListDTO toDto(StaffList entity);

    public abstract StaffList toEntity(StaffListDTO staffListDTO);

    public StaffListDTO toDto(String stringDTO) {

        List<String> stringList = Arrays.stream(stringDTO.split("&&"))
                .collect(Collectors.toList());

        stringList = stringList.stream().map(s->{
            if (s.equals(ExcelHelper.EMPTY_SING_EXCEL)) {
                return ExcelHelper.EMPTY_SING;
            }
            return s;
        }).toList();

        StaffListDTO dto = new StaffListDTO();

        dto.setStaffListId(stringList.get(INDEX_STAFF_LIST_ID));
        UserPositionDTO userPositionDTO = new UserPositionDTO();
        userPositionDTO.setUserPositionCodeIdPro(stringList.get(INDEX_USER_POSITION_CODE));
        userPositionDTO.setName(stringList.get(INDEX_USER_POSITION_NAME));
        dto.setUserPosition(userPositionDTO);
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setName(stringList.get(INDEX_DEPARTMENT_NAME));
        departmentDTO.setDepartmentIsProId(stringList.get(INDEX_DEPARTMENT_CODE));
        dto.setDepartment(departmentDTO);
        dto.setEmployment(Float.parseFloat(stringList.get(INDEX_EMPLOYMENT)));
        dto.setIPN(stringList.get(INDEX_IPN));

        log.info(dto.toString());
        return dto;
    }
}
