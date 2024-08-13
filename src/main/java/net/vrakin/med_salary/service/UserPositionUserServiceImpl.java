package net.vrakin.med_salary.service;

import net.vrakin.med_salary.entity.User;
import net.vrakin.med_salary.entity.UserPosition;
import net.vrakin.med_salary.entity.UserPositionUser;
import net.vrakin.med_salary.repository.UserPositionUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPositionUserServiceImpl extends AbstractService<UserPositionUser> implements UserPositionUserService {

    private final UserPositionUserRepository userPositionUserRepository;

    @Autowired
    public UserPositionUserServiceImpl(UserPositionUserRepository userPositionUserRepository) {
        super(userPositionUserRepository);
        this.userPositionUserRepository = userPositionUserRepository;
    }

    @Override
    public List<UserPositionUser> findByUser(User user) {
        return userPositionUserRepository.findByUser(user);
    }

    @Override
    public List<UserPositionUser> findByUserPosition(UserPosition userPosition) {
        return userPositionUserRepository.findByUserPosition(userPosition);
    }

    @Override
    public List<UserPositionUser> findByEmploymentBetween(float lower, float higher) {
        return userPositionUserRepository.findByEmploymentBetween(lower, higher);
    }
}
