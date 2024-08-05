package net.vrakin.med_salary.service;

import net.vrakin.med_salary.dto.UserDTO;
import net.vrakin.med_salary.entity.Role;
import net.vrakin.med_salary.exception.ResourceNotFoundException;
import net.vrakin.med_salary.mapper.AbstractMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class AbstractService<E> {
    protected final JpaRepository<E, Long> repository;

    protected AbstractService(JpaRepository<E, Long> repository) {
        this.repository = repository;
    }
    public List<E> findAll() {
        return repository.findAll();
    }

    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    public E save(E entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity", "id", id.toString()));
        repository.deleteById(id);
    }

    public void deleteAllById(List<Long> ids) {
        ids.forEach(this::deleteById);
    }

    public List<E> findAllById(List<Long> ids) throws ResourceNotFoundException {
        return repository.findAllById(ids);
    }
}
