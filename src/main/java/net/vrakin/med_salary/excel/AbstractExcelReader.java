package net.vrakin.med_salary.excel;

import net.vrakin.med_salary.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractExcelReader<E, D> implements ExcelReader<E, D> {

    protected BaseMapper<E, D> mapper;

    private String filename;

    private ExcelHelper excelHelper;

    @Autowired
    public AbstractExcelReader(String filename, ExcelHelper excelHelper,
                                    BaseMapper<E, D> mapper) {
        this.filename = filename;
        this.excelHelper = excelHelper;
        this.mapper = mapper;
    }

    protected List<String> readExcel(){
        return excelHelper.readExcel(this.filename);
    }

    public List<E> readAllEntries(){
        return mapper.toEntityList(readAllDto());
    }

    public List<D> readAllDto(){

        List<D> result = new ArrayList<>();

        return mapper.toDtoFromStringList(readExcel());
    }
}
