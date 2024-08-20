package net.vrakin.med_salary.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface BaseMapper <E, D>{
    D toDto(E entity);
    E toEntity(D dto);
    default List<D> toDtoList(List<E> entityList){
        return entityList.stream().map(e->toDto(e)).collect(Collectors.toList());
    }
    default List<E> toEntityList(List<D> dtoList){
        return dtoList.stream().map(d->toEntity(d)).collect(Collectors.toList());
    }

    D toDto(String stringDto);
    E toEntity(String stringEntity);

    default List<D> toDtoFromStringList(List<String> stringList){
        return stringList.stream().map(s->toDto(s)).collect(Collectors.toList());
    }
    default List<E> toEntityFromStringList(List<String> stringList){
        return stringList.stream().map(s->toEntity(s)).collect(Collectors.toList());
    }
}
