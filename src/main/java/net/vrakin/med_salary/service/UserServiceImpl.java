package net.vrakin.med_salary.service;

import lombok.AllArgsConstructor;
import net.vrakin.med_salary.dto.UserDTO;
import net.vrakin.med_salary.entity.User;
import net.vrakin.med_salary.mapper.UserMapper;
import net.vrakin.med_salary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the UserService interface.
 * This service class provides methods for managing User entities.
 */
@Service
public class UserServiceImpl extends AbstractService<User, UserDTO> implements UserService {

    @Autowired
    public UserServiceImpl(UserRepository repository, UserMapper mapper){
        super(repository, mapper);
    }

    private UserRepository userRepository;

    @Override
    public Optional<UserDTO> findByLogin(String login) {
        return getDTO(userRepository.findByLogin(login));
    }

    @Override
    public List<UserDTO> findBySpecialty(String specialty) {
        return getDTOCollect(userRepository.findBySpeciality(specialty));
    }

    @Override
    public List<UserDTO> findByName(String name) {
        return getDTOCollect(userRepository.findByName(name));
    }
}