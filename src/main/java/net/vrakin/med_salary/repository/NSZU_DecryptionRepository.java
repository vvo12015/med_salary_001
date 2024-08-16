package net.vrakin.med_salary.repository;

import net.vrakin.med_salary.entity.NSZU_Decryption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NSZU_DecryptionRepository extends JpaRepository<NSZU_Decryption, Long> {
    List<NSZU_Decryption> findByExecutorNameAndExecutorUserPosition(String executorName, String executorUserPosition);
    List<NSZU_Decryption> findByExecutorName(String executorName);
    List<NSZU_Decryption> findByYearAndMonth(int year, int month);
    List<NSZU_Decryption> findByRecordKind(String recordKind);
    List<NSZU_Decryption> findByProviderPlace(String providerPlace);
    List<NSZU_Decryption> findByServicePackage(String servicePackage);
}
