package net.vrakin.med_salary.excel;

import net.vrakin.med_salary.dto.NSZUDecryptionDTO;
import net.vrakin.med_salary.entity.NSZU_Decryption;
import net.vrakin.med_salary.mapper.NSZU_DecryptionMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NszuDecryptionExcelReader extends AbstractExcelReader<NSZU_Decryption, NSZUDecryptionDTO>
        implements ExcelReader<NSZU_Decryption, NSZUDecryptionDTO> {

    @Autowired
    public NszuDecryptionExcelReader(String filename, ExcelHelper excelHelper,
                                NSZU_DecryptionMapper mapper) {
        super(filename, excelHelper, mapper);
    }

}
