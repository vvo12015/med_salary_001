package net.vrakin.med_salary.service;

import net.vrakin.med_salary.entity.Department;
import net.vrakin.med_salary.entity.NSZU_Decryption;
import net.vrakin.med_salary.entity.Role;
import net.vrakin.med_salary.entity.User;
import net.vrakin.med_salary.repository.NSZU_DecryptionRepository;
import net.vrakin.med_salary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NSZU_DecryptionImpl extends AbstractService<NSZU_Decryption> implements NSZU_DecryptionService {

    @Autowired
    public NSZU_DecryptionImpl(NSZU_DecryptionRepository repository){
        super(repository);
        this.nszuDecryptionRepository = repository;
    }

    private NSZU_DecryptionRepository nszuDecryptionRepository;

    @Override
    public List<NSZU_Decryption> findByExecutorNameAndExecutorUserPosition(String executorName, String executorUserPosition) {
        return nszuDecryptionRepository.findByExecutorNameAndExecutorUserPosition(executorName, executorUserPosition);
    }

    @Override
    public List<NSZU_Decryption> findByYearAndMonth(int year, int month) {
        return nszuDecryptionRepository.findByYearAndMonth(year, month);
    }

    @Override
    public List<NSZU_Decryption> findByRecordKind(String recordKind) {
        return nszuDecryptionRepository.findByRecordKind(recordKind);
    }

    @Override
    public List<NSZU_Decryption> findByProviderPlace(String providerPlace) {
        return nszuDecryptionRepository.findByProviderPlace(providerPlace);
    }

    @Override
    public List<NSZU_Decryption> findByServicePackage(String servicePackage) {
        return nszuDecryptionRepository.findByServicePackage(servicePackage);
    }
}