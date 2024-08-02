package net.vrakin.med_salary.service;

import lombok.AllArgsConstructor;
import net.vrakin.med_salary.dto.UserDTO;
import net.vrakin.med_salary.entity.User;
import net.vrakin.med_salary.exception.ResourceNotFoundException;
import net.vrakin.med_salary.mapper.UserMapper;
import net.vrakin.med_salary.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the UserService interface.
 * This service class provides methods for managing User entities.
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    /**
     * Retrieves all users.
     *
     * @return A list of UserDTO objects representing all users.
     */
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        return getUserCollect(users);
    }

    /**
     * Finds a user by their login.
     *
     * @param login The login of the user to find.
     * @return An Optional containing the UserDTO if found, or empty if not found.
     */
    @Override
    public Optional<UserDTO> findByLogin(String login) {
        return getUserDTO(userRepository.findByLogin(login));
    }

    /**
     * Finds users by their specialty.
     *
     * @param specialty The specialty to search for.
     * @return A list of UserDTO objects matching the given specialty.
     */
    @Override
    public List<UserDTO> findBySpecialty(String specialty) {
        return getUserCollect(userRepository.findBySpeciality(specialty));
    }

    /**
     * Finds a user by their ID.
     *
     * @param id The ID of the user to find.
     * @return An Optional containing the UserDTO if found, or empty if not found.
     */
    @Override
    public Optional<UserDTO> findById(Long id) {
        return getUserDTO(userRepository.findById(id));
    }

    /**
     * Finds users by their name.
     *
     * @param name The name to search for.
     * @return A list of UserDTO objects matching the given name.
     */
    @Override
    public List<UserDTO> findByName(String name) {
        return getUserCollect(userRepository.findByName(name));
    }

    /**
     * Saves a new user or updates an existing one.
     *
     * @param userDTO The UserDTO object to save or update.
     * @return The saved or updated UserDTO object.
     */
    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = UserMapper.USER_MAPPER.mapToUser(userDTO);
        return UserMapper.USER_MAPPER.mapToUserDTO(userRepository.save(user));
    }

    /**
     * Deletes a user.
     *
     * @param userDTO The UserDTO object to delete.
     * @throws ResourceNotFoundException if the user is not found.
     */
    @Override
    public void delete(UserDTO userDTO) {
        User user = UserMapper.USER_MAPPER.mapToUser(userDTO);
        userRepository.findById(user.getId()).orElseThrow(() -> new ResourceNotFoundException("User", "id", user.getId().toString()));
        userRepository.delete(user);
    }

    /**
     * Deletes a user by their ID.
     *
     * @param id The ID of the user to delete.
     * @throws ResourceNotFoundException if the user is not found.
     */
    @Override
    public void deleteById(Long id) {
        userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id.toString()));
        userRepository.deleteById(id);
    }

    /**
     * Deletes multiple users by their IDs.
     *
     * @param ids A list of user IDs to delete.
     */
    @Override
    public void deleteAllById(List<Long> ids) {
        ids.forEach(this::deleteById);
    }

    /**
     * Converts an Optional<User> to an Optional<UserDTO>.
     *
     * @param searchUser The Optional<User> to convert.
     * @return An Optional<UserDTO> if the input is present, or an empty Optional otherwise.
     */
    private Optional<UserDTO> getUserDTO(Optional<User> searchUser) {
        return searchUser.map(UserMapper.USER_MAPPER::mapToUserDTO);
    }

    /**
     * Converts a List<User> to a List<UserDTO>.
     *
     * @param users The List<User> to convert.
     * @return A List<UserDTO> containing the converted User objects.
     */
    private List<UserDTO> getUserCollect(List<User> users) {
        return users.stream()
                .map(UserMapper.USER_MAPPER::mapToUserDTO)
                .collect(Collectors.toList());
    }
}