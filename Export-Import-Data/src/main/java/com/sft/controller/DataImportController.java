package com.sft.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.sft.service.DataImportService;

@WebServlet("/import")
@MultipartConfig(maxFileSize = 16177215)
public class DataImportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("upload-file.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Retrieved");
		PrintWriter printWriter = response.getWriter();
	    Part filePart = request.getPart("file");
	    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
	    InputStream fileContent = filePart.getInputStream();
	    try {
			DataImportService dataImportService = new DataImportService();
			Boolean result = dataImportService.importData(fileName, fileContent);
			printWriter.append(result.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	}
	
}
