package net.vrakin.med_salary.mapper;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractMapper<E, D> implements BaseMapper<E, D> {

    public abstract D toDto(E entity);
    public abstract E toEntity(D dto);

    @Override
    public List<D> toDtoList(List<E> entityList) {
        if (entityList == null) {
            return null;
        }
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<E> toEntityList(List<D> dtoList) {
        if (dtoList == null) {
            return null;
        }
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }


}