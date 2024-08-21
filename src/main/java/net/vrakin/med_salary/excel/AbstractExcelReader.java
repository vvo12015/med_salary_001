package net.vrakin.med_salary.excel;

import net.vrakin.med_salary.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractExcelReader<E, D> implements ExcelReader<E, D> {

    protected BaseMapper<E, D> mapper;

    private ExcelHelper excelHelper;

    @Autowired
    public AbstractExcelReader(ExcelHelper excelHelper,
                                    BaseMapper<E, D> mapper) {
        this.excelHelper = excelHelper;
        this.mapper = mapper;
    }


    public AbstractExcelReader(File file, ExcelHelper excelHelper,
                               BaseMapper<E, D> mapper) {
        this.excelHelper = excelHelper;
        this.mapper = mapper;
    }

    protected List<String> readExcel(File file){
        return excelHelper.readExcel(file);
    }

    public List<E> readAllEntries(File file){
        return mapper.toEntityList(readAllDto(file));
    }

    public List<D> readAllDto(File file){

        List<D> result = new ArrayList<>();

        return mapper.toDtoFromStringList(readExcel(file));
    }
}
