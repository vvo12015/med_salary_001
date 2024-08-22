package net.vrakin.med_salary.service;

import net.vrakin.med_salary.entity.NszuDecryption;

import java.util.List;

public interface NSZU_DecryptionService extends Service<NszuDecryption> {

    List<NszuDecryption> findByExecutorNameAndExecutorUserPosition(String executorName, String executorUserPosition);

    List<NszuDecryption> findByYearAndMonth(int year, int month);

    List<NszuDecryption> findByRecordKind(String recordKind);

    List<NszuDecryption> findByProviderPlace(String providerPlace);

    List<NszuDecryption> findByServicePackage(String servicePackage);

    List<NszuDecryption> findByExecutorName(String executorName);
}