package net.vrakin.med_salary.service;

import net.vrakin.med_salary.dto.UserDTO;
import net.vrakin.med_salary.exception.ResourceNotFoundException;
import net.vrakin.med_salary.mapper.AbstractMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<E, D> {
    protected final JpaRepository<E, Long> repository;
    protected final AbstractMapper<E, D> mapper;

    protected AbstractService(JpaRepository<E, Long> repository, AbstractMapper<E, D> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    public List<D> findAll() {
        List<E> entities = repository.findAll();
        return getDTOCollect(entities);
    }

    public Optional<D> findById(Long id) {
        return getDTO(repository.findById(id));
    }

    public D save(D dto) {
        E entity = mapper.toEntity(dto);
        return mapper.toDto(entity);
    }

    public void deleteById(Long id) {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity", "id", id.toString()));
        repository.deleteById(id);
    }

    public void deleteAllById(List<Long> ids) {
        ids.forEach(this::deleteById);
    }

    protected Optional<D> getDTO(Optional<E> searchEntity) {
        return searchEntity.map(mapper::toDto);
    }

    protected List<D> getDTOCollect(List<E> entities) {
        return mapper.toDtoList(entities);
    }
}
