package net.vrakin.med_salary.service;

import net.vrakin.med_salary.entity.Department;
import net.vrakin.med_salary.entity.Role;
import net.vrakin.med_salary.entity.User;
import net.vrakin.med_salary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl extends AbstractService<User> implements UserService {

    @Autowired
    public UserServiceImpl(UserRepository repository){
        super(repository);
    }

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository repository){
        this.userRepository = repository;
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public List<User> findBySpecialty(String specialty) {
        return userRepository.findBySpecialityName(specialty);
    }

    @Override
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public List<User> findByRole(Role role) {
        return userRepository.findByRole(role);
    }

    @Override
    public List<User> findByDepartment(Department department) {
        return userRepository.findByDepartment(department);
    }

    @Override
    public List<User> findByNameLike(String namePattern) {
        return userRepository.findByNameLike(namePattern+"%");
    }
}