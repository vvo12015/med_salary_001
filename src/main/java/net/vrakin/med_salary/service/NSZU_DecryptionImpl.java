package net.vrakin.med_salary.service;

import net.vrakin.med_salary.domain.NszuDecryption;
import net.vrakin.med_salary.repository.NSZU_DecryptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NSZU_DecryptionImpl extends AbstractService<NszuDecryption> implements NSZU_DecryptionService {

    @Autowired
    public NSZU_DecryptionImpl(NSZU_DecryptionRepository repository){
        super(repository);
        this.nszuDecryptionRepository = repository;
    }

    private NSZU_DecryptionRepository nszuDecryptionRepository;

    @Override
    public List<NszuDecryption> findByExecutorNameAndExecutorUserPosition(String executorName, String executorUserPosition) {
        return nszuDecryptionRepository.findByExecutorNameAndExecutorUserPosition(executorName, executorUserPosition);
    }

    @Override
    public List<NszuDecryption> findByYearAndMonth(int year, int month) {
        return nszuDecryptionRepository.findByYearAndMonth(year, month);
    }

    @Override
    public List<NszuDecryption> findByRecordKind(String recordKind) {
        return nszuDecryptionRepository.findByRecordKind(recordKind);
    }

    @Override
    public List<NszuDecryption> findByProviderPlace(String providerPlace) {
        return nszuDecryptionRepository.findByProviderPlace(providerPlace);
    }

    @Override
    public List<NszuDecryption> findByServicePackage(String servicePackage) {
        return nszuDecryptionRepository.findByServicePackage(servicePackage);
    }

    @Override
    public List<NszuDecryption> findByExecutorName(String executorName) {
        return nszuDecryptionRepository.findByExecutorName(executorName);
    }
}