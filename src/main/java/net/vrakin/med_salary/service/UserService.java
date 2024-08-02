package net.vrakin.med_salary.service;

import net.vrakin.med_salary.dto.UserDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing User entities.
 * Extends the generic Service interface with UserDTO as the entity type.
 */
public interface UserService extends Service<UserDTO> {

    /**
     * Finds a user by their login.
     *
     * @param login The login of the user to find.
     * @return An Optional containing the UserDTO if found, or empty if not found.
     */
    Optional<UserDTO> findByLogin(String login);

    /**
     * Finds users by their specialty.
     *
     * @param specialty The specialty to search for.
     * @return A list of UserDTO objects matching the given specialty.
     */
    List<UserDTO> findBySpecialty(String specialty);
}