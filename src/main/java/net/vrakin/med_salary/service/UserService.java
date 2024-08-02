package net.vrakin.med_salary.service;

import net.vrakin.med_salary.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService extends Service<User>{

    Optional<User> findByLogin(String login);
    List<User> findBySpecialty(String specialty);
}
