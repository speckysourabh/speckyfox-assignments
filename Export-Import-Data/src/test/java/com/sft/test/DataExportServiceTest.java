package com.sft.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sft.pojo.Person;
import com.sft.service.DataExportService;
import com.sft.utils.QueryMaker;

@ExtendWith(MockitoExtension.class)
public class DataExportServiceTest {

	@Mock
	private Connection connection;

	@Mock
	private PreparedStatement preparedStatement;

	@Mock
	private QueryMaker queryMaker;

	@Mock
	private ResultSet resultSet;

	@BeforeEach
	 public void setUp() throws Exception {
	 when(queryMaker.getPreparedStatement(anyString())).thenReturn(preparedStatement);
	 when(preparedStatement.executeQuery()).thenReturn(resultSet);
	 }

	@Test
	public void testGetPersons() throws Exception {

		Person person1 = new Person(1L, "John", 1234567890L, "123 Main St", "Male");
		Person person2 = new Person(2L, "Alice", 9876543210L, "456 Elm St", "Female");

		when(resultSet.next()).thenReturn(true, true);
		when(resultSet.getLong(1)).thenReturn(person1.getId(), person2.getId());
		when(resultSet.getString(2)).thenReturn(person1.getName(), person2.getName());
		when(resultSet.getLong(3)).thenReturn(person1.getPhone(), person2.getPhone());
		when(resultSet.getString(4)).thenReturn(person1.getAddress(), person2.getAddress());
		when(resultSet.getString(5)).thenReturn(person1.getGender(), person2.getGender());

		List<Person> expectedPersons = new ArrayList<>();
		expectedPersons.add(person1);
		expectedPersons.add(person2);


		DataExportService dataExportService = new DataExportService(queryMaker);
		List<Person> actualPersons = dataExportService.getPersons();

		assertEquals(expectedPersons, actualPersons);

		// Verify that the necessary methods were called
		verify(queryMaker).getPreparedStatement("select * from person");
		verify(preparedStatement).executeQuery();
		verify(resultSet, times(2)).next();
		verify(resultSet).getLong(1);
		verify(resultSet).getString(2);
		verify(resultSet).getLong(3);
		verify(resultSet).getString(4);
		verify(resultSet).getString(5);

		verifyNoMoreInteractions(queryMaker, preparedStatement, resultSet);
	}

}
