package net.vrakin.med_salary.service;

import net.vrakin.med_salary.dto.RoleDTO;
import net.vrakin.med_salary.dto.UserDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing User entities.
 * Extends the generic Service interface with UserDTO as the entity type.
 */
public interface UserService extends Service<UserDTO> {

    Optional<UserDTO> findByLogin(String login);

    List<UserDTO> findBySpecialty(String specialty);

    List<UserDTO> findByName(String name);
}