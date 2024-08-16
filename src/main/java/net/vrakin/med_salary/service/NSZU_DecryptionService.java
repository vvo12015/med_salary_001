package net.vrakin.med_salary.service;

import net.vrakin.med_salary.entity.NSZU_Decryption;

import java.util.List;

public interface NSZU_DecryptionService extends Service<NSZU_Decryption> {

    List<NSZU_Decryption> findByExecutorNameAndExecutorUserPosition(String executorName, String executorUserPosition);

    List<NSZU_Decryption> findByYearAndMonth(int year, int month);

    List<NSZU_Decryption> findByRecordKind(String recordKind);

    List<NSZU_Decryption> findByProviderPlace(String providerPlace);

    List<NSZU_Decryption> findByServicePackage(String servicePackage);

    List<NSZU_Decryption> findByExecutorName(String executorName);
}