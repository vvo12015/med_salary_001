package net.vrakin.med_salary.service;

import net.vrakin.med_salary.domain.Department;
import net.vrakin.med_salary.domain.Role;
import net.vrakin.med_salary.domain.mapping.users.AbstractUser;
import net.vrakin.med_salary.domain.mapping.users.User;

import java.util.List;
import java.util.Optional;

public interface UserService extends Service<AbstractUser> {

    Optional<User> findByName(String name);

    Optional<User> findByIPN(String IPN);
}