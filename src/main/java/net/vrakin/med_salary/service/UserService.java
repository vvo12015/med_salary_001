package net.vrakin.med_salary.service;

import net.vrakin.med_salary.domain.Department;
import net.vrakin.med_salary.domain.Role;
import net.vrakin.med_salary.domain.mapping.users.User;

import java.util.List;
import java.util.Optional;

public interface UserService extends Service<User> {

    Optional<User> findByLogin(String login);

    List<User> findBySpecialty(String specialtyName);

    List<User> findByName(String name);

    List<User> findByRole(Role role);

    List<User> findByDepartment(Department department);

    List<User> findByNameLike(String namePattern);
}