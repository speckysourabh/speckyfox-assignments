package com.sft.service;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sft.utils.DbConnection;
import com.sft.utils.QueryMaker;

public class DataImportService {
	
	private QueryMaker queryMaker;
	
	public DataImportService() throws Exception {
		super();
		this.queryMaker = new QueryMaker(DbConnection.getInstance().openConnection());
	}

	public boolean importData(String fileName, InputStream inputStream) throws SQLException {
		PreparedStatement preparedStatement = queryMaker.getPreparedStatement("insert into myfiles (file_name, file_content) values(?, ?)");
		preparedStatement.setString(1, fileName);
		preparedStatement.setBlob(2, inputStream);
		int row = preparedStatement.executeUpdate();
		
		if(row > 0) {
			System.out.println("File uploaded successfully!");
			return true;
		} else {
			System.out.println("Unable to upload file!");
			return false;
		}
	}
	
}
