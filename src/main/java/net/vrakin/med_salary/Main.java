package net.vrakin.med_salary;


import net.vrakin.med_salary.dto.NSZUDecryptionDTO;
import net.vrakin.med_salary.excel.FastExcelHelper;
import net.vrakin.med_salary.mapper.BaseMapper;
import net.vrakin.med_salary.mapper.NSZU_DecryptionMapper;
import net.vrakin.med_salary.mapper.NSZU_DecryptionMapperImpl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        FastExcelHelper fastExcelHelper = new FastExcelHelper();

        List<String> data = fastExcelHelper.readExcel("src/main/resources/excel/1.xlsx");

        /*data.forEach(r->{
            System.out.print(r);
            System.out.println();
        });*/

        System.out.println(data.get(data.size()-5));

        BaseMapper mapper = new NSZU_DecryptionMapperImpl();

        NSZUDecryptionDTO nszuDecryptionDTO = (NSZUDecryptionDTO) mapper.toDto(data.get(data.size()-5));

        System.out.println(nszuDecryptionDTO);
    }
}
