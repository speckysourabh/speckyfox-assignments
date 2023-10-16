package com.sft.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private static Connection connection;
	private static DbConnection dbConnection;
	
	private DbConnection() {}
	
	public Connection openConnection() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exceldb", "root", "admin");
			
		} catch (Exception exception) {
			throw exception;
		}
		return connection;
	}
	
	public void closeConnection() throws SQLException {
		if(connection!=null) {
			connection.close();
		}
	}
	
	public static DbConnection getInstance() {
		if(dbConnection==null) {
			dbConnection = new DbConnection();
		}
		return dbConnection;
	}

}
