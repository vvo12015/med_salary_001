package net.vrakin.med_salary.service;

import net.vrakin.med_salary.domain.UserPosition;
import net.vrakin.med_salary.domain.mapping.department.MapDepartment;
import net.vrakin.med_salary.domain.mapping.users.StaffList;
import net.vrakin.med_salary.repository.StaffListRepository;
import net.vrakin.med_salary.repository.UserPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffListServiceImpl extends AbstractService<StaffList> implements StaffListService  {

    private final StaffListRepository staffListRepository;

    @Autowired
    public StaffListServiceImpl(StaffListRepository staffListRepository){
        super(staffListRepository);
        this.staffListRepository = staffListRepository;
    }
    @Override
    public List<StaffList> findByUserPositionDepartment(UserPosition userPosition, MapDepartment mapDepartment) {
        return staffListRepository.findByUserPositionDepartment(userPosition, mapDepartment);
    }
}
