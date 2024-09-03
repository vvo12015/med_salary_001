package net.vrakin.med_salary.service;

import net.vrakin.med_salary.domain.mapping.users.StaffList;
import net.vrakin.med_salary.domain.mapping.users.User;
import net.vrakin.med_salary.domain.UserPosition;
import net.vrakin.med_salary.repository.UserPositionUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPositionUserServiceImpl extends AbstractService<StaffList> implements UserPositionUserService {

    private final UserPositionUserRepository userPositionUserRepository;

    @Autowired
    public UserPositionUserServiceImpl(UserPositionUserRepository userPositionUserRepository) {
        super(userPositionUserRepository);
        this.userPositionUserRepository = userPositionUserRepository;
    }

    @Override
    public List<StaffList> findByUser(User user) {
        return userPositionUserRepository.findByUser(user);
    }

    @Override
    public List<StaffList> findByUserPosition(UserPosition userPosition) {
        return userPositionUserRepository.findByUserPosition(userPosition);
    }

    @Override
    public List<StaffList> findByEmploymentBetween(float lower, float higher) {
        return userPositionUserRepository.findByEmploymentBetween(lower, higher);
    }
}
