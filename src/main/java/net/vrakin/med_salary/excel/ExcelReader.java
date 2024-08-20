package net.vrakin.med_salary.excel;

import java.util.List;

public interface ExcelReader<E, D> {
    List<E> readAllEntries();
    List<D> readAllDto();
}
