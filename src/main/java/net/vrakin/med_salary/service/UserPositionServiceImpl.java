package net.vrakin.med_salary.service;

import net.vrakin.med_salary.entity.UserPosition;
import net.vrakin.med_salary.repository.UserPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserPositionServiceImpl extends AbstractService<UserPosition> implements UserPositionService {

    private final UserPositionRepository userPositionRepository;

    @Autowired
    public UserPositionServiceImpl(UserPositionRepository userPositionRepository){
        super(userPositionRepository);
        this.userPositionRepository = userPositionRepository;
    }

    @Override
    public Optional<UserPosition> findByName(String name) {
        return userPositionRepository.findByName(name);
    }
}
