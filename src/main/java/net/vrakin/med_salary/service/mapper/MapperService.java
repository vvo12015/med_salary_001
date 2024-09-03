package net.vrakin.med_salary.service.mapper;

import java.util.Optional;

public interface MapperService<E, D> {
    E mappedToEntity(D dto);
}
