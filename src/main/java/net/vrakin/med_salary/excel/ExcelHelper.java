package net.vrakin.med_salary.excel;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

public interface ExcelHelper {
    public static final String EMPTY_SING_EXCEL = "-";
    public static final String EMPTY_SING = "0";
    List<String> readExcel(File file);
    LocalDateTime mapToDate(String excelStringDate);
}
