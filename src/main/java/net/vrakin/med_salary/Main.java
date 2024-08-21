package net.vrakin.med_salary;


import net.vrakin.med_salary.dto.NszuDecryptionDTO;
import net.vrakin.med_salary.excel.FastExcelHelper;
import net.vrakin.med_salary.mapper.BaseMapper;
import net.vrakin.med_salary.mapper.NSZU_DecryptionMapperImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        FastExcelHelper fastExcelHelper = new FastExcelHelper();

        File file = new File("src/main/resources/excel/1.xlsx");
        List<String> data = fastExcelHelper.readExcel(file);

        /*data.forEach(r->{
            System.out.print(r);
            System.out.println();
        });*/

        System.out.println(data.get(data.size()-5));

        BaseMapper mapper = new NSZU_DecryptionMapperImpl();

        NszuDecryptionDTO nszuDecryptionDTO = (NszuDecryptionDTO) mapper.toDto(data.get(data.size()-5));

        System.out.println(nszuDecryptionDTO);
    }
}
