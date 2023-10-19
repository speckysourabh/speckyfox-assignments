package com.sft.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sft.pojo.Person;

public class ExcelProcessing {

	public List<Person> excelToPerson(String fileName, InputStream fileContent) throws Exception {
		List<Person> persons = new ArrayList<>();
		Workbook workbook = null;
		if (fileName.toLowerCase().endsWith("xlsx")) {
			workbook = new XSSFWorkbook(fileContent);
		} else {
			throw new Exception("File format not supported");
		}

		Sheet sheet = workbook.getSheetAt(0);

		for(Row row : sheet) {

			if(row.getRowNum()==0) {
				continue;
			}
			
			Person person = new Person();
			person.setId((long) row.getCell(0).getNumericCellValue());
			person.setName(row.getCell(1).getStringCellValue());
			person.setPhone((long) row.getCell(2).getNumericCellValue());
			person.setAddress(row.getCell(3).getStringCellValue());
			person.setGender(row.getCell(4).getStringCellValue());
			persons.add(person);

		}

		return persons;
	}

}
