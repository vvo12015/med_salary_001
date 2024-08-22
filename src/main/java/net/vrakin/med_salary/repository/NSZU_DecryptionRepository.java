package net.vrakin.med_salary.repository;

import net.vrakin.med_salary.entity.NszuDecryption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NSZU_DecryptionRepository extends JpaRepository<NszuDecryption, Long> {
    List<NszuDecryption> findByExecutorNameAndExecutorUserPosition(String executorName, String executorUserPosition);
    List<NszuDecryption> findByExecutorName(String executorName);
    List<NszuDecryption> findByYearAndMonth(int year, int month);
    List<NszuDecryption> findByRecordKind(String recordKind);
    List<NszuDecryption> findByProviderPlace(String providerPlace);
    List<NszuDecryption> findByServicePackage(String servicePackage);
}
