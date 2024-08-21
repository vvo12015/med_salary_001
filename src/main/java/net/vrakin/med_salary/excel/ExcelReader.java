package net.vrakin.med_salary.excel;

import java.io.File;
import java.util.List;

public interface ExcelReader<E, D> {
    List<E> readAllEntries(File file);
    List<D> readAllDto(File file);
}
