package com.sft.test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sft.pojo.Person;
import com.sft.service.DataImportService;
import com.sft.utils.QueryMaker;

@ExtendWith(MockitoExtension.class)
public class DataImportServiceTest {

	@Mock
	private Connection connection;

	@Mock
	private PreparedStatement preparedStatement;

	@Mock
	private QueryMaker queryMaker;

	@BeforeEach
	public void setUp() throws SQLException {

	}

	@Test
	public void testImportExcelData() throws Exception {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person(1L, "John", 1234567890L, "123 Main St", "Male"));
		when(preparedStatement.executeUpdate()).thenReturn(1);
		when(queryMaker.getPreparedStatement(anyString())).thenReturn(preparedStatement);
		DataImportService yourClass = new DataImportService(queryMaker);

		yourClass.importExcelData(persons);

		verify(preparedStatement).setLong(1, 1);
		verify(preparedStatement).setString(2, "John");
		verify(preparedStatement).setLong(3, 1234567890);
		verify(preparedStatement).setString(4, "123 Main St");
		verify(preparedStatement).setString(5, "Male");
		verify(preparedStatement).executeUpdate();

	}

}
