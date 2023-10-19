package com.sft.service;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.util.List;

import com.sft.pojo.Person;
import com.sft.utils.QueryMaker;

public class DataImportService {

	private QueryMaker queryMaker;

	public DataImportService(QueryMaker queryMaker) throws Exception {
		super();
		this.queryMaker = queryMaker;
	}

	public boolean importData(String fileName, InputStream inputStream) throws Exception {

		if (!fileName.substring(fileName.lastIndexOf('.')).equals(".docx")) {
			throw new Exception("File format not supported");
		}

		PreparedStatement preparedStatement = queryMaker
				.getPreparedStatement("insert into myfiles (file_name, file_content) values(?, ?)");
		preparedStatement.setString(1, fileName);
		preparedStatement.setBlob(2, inputStream);
		int row = preparedStatement.executeUpdate();

		if (row > 0) {
			System.out.println("File uploaded successfully!");
			return true;
		} else {
			System.out.println("Unable to upload file!");
			return false;
		}
	}

	public void importExcelData(List<Person> persons) throws Exception {
		for (Person person : persons) {
			PreparedStatement preparedStatement = queryMaker.getPreparedStatement(
					"insert into person (id, name, phone, address, gender) values(?, ?, ?, ?, ?)");
			preparedStatement.setLong(1, person.getId());
			preparedStatement.setString(2, person.getName());
			preparedStatement.setLong(3, person.getPhone());
			preparedStatement.setString(4, person.getAddress());
			preparedStatement.setString(5, person.getGender());
			int row = preparedStatement.executeUpdate();

			if (row > 0) {
				System.out.println("Record added successfully!");
			} else {
				System.out.println("Unable to add record!");
			}
		}
	}

}
