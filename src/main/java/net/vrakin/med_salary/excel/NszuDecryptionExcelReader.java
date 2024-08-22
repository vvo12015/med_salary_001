package net.vrakin.med_salary.excel;

import net.vrakin.med_salary.dto.NszuDecryptionDTO;
import net.vrakin.med_salary.entity.NszuDecryption;
import net.vrakin.med_salary.mapper.NSZU_DecryptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NszuDecryptionExcelReader extends AbstractExcelReader<NszuDecryption, NszuDecryptionDTO>
        implements ExcelReader<NszuDecryption, NszuDecryptionDTO> {

    @Autowired
    public NszuDecryptionExcelReader(ExcelHelper excelHelper,
                                NSZU_DecryptionMapper mapper) {
        super(excelHelper, mapper);
    }

}
