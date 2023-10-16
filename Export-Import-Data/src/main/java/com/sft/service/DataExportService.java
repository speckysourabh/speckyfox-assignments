package com.sft.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sft.utils.DbConnection;
import com.sft.utils.QueryMaker;

public class DataExportService {

	private QueryMaker queryMaker;

	public DataExportService() throws Exception {
		super();
		this.queryMaker = new QueryMaker(DbConnection.getInstance().openConnection());
	}

	public List<String> getAllFiles() throws SQLException {
		PreparedStatement preparedStatement = queryMaker.getPreparedStatement("select file_name from myfiles");
		ResultSet resultSet = preparedStatement.executeQuery();
		List<String> paths = new ArrayList<>();
		while (resultSet.next()) {
			paths.add(resultSet.getString(1));
		}
		return paths;
	}

}
