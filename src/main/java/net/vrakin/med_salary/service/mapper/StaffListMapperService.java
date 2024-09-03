package net.vrakin.med_salary.service.mapper;

import net.vrakin.med_salary.dto.StaffListDTO;
import net.vrakin.med_salary.domain.StaffList;

import java.util.Optional;

public interface StaffListMapperService {
    Optional<StaffList> mappedToEntity(StaffListDTO staffListDTO);
}
