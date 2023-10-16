package com.sft.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QueryMaker {
	
	private Connection connection;
	
	public QueryMaker(Connection connection) {
		this.connection = connection;
	}

	public PreparedStatement getPreparedStatement(String sql) throws SQLException {
		return connection.prepareStatement(sql);
	}
	
}
