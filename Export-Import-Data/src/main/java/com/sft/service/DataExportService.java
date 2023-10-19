package com.sft.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sft.pojo.Person;
import com.sft.utils.QueryMaker;

public class DataExportService {

	private QueryMaker queryMaker;

	public DataExportService(QueryMaker queryMaker) throws Exception {
		super();
		this.queryMaker = queryMaker;
	}

	public List<Person> getPersons() throws SQLException {
		PreparedStatement preparedStatement = queryMaker.getPreparedStatement("select * from person");
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Person> persons = new ArrayList<>();
		while (resultSet.next()) {
			Person person = new Person();
			person.setId(resultSet.getLong(1));
			person.setName(resultSet.getString(2));
			person.setPhone(resultSet.getLong(3));
			person.setAddress(resultSet.getString(4));
			person.setGender(resultSet.getString(5));
			persons.add(person);
		}
		return persons;
	}


}
