package net.vrakin.med_salary.service;

import net.vrakin.med_salary.domain.Department;
import net.vrakin.med_salary.domain.Role;
import net.vrakin.med_salary.domain.mapping.users.AbstractUser;
import net.vrakin.med_salary.domain.mapping.users.User;
import net.vrakin.med_salary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class UserServiceImpl extends AbstractService<AbstractUser> implements UserService {

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        super(userRepository);
        this.userRepository = userRepository;
    }

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository repository){
        this.userRepository = repository;
    }

    @Override
    public Optional<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public Optional<User> findByIPN(String IPN) {
        return userRepository.findByIPN(IPN);
    }
}