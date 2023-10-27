package com.sft.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import com.sft.pojo.Person;
import com.sft.service.DataExportService;
import com.sft.utils.DbConnection;
import com.sft.utils.QueryMaker;
import com.sft.utils.TemplatesHtml;

@WebServlet("/export")
public class DataExportController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/pdf");
		try {
			DataExportService dataExportService = new DataExportService(
					new QueryMaker(DbConnection.getInstance().openConnection()));
			List<Person> persons = dataExportService.getPersons();
			System.out.println(persons);
//			template2(response, persons);
			template1(request, response, persons);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void template1(HttpServletRequest request, HttpServletResponse response, List<Person> persons) throws FileNotFoundException, IOException, ServletException {
		
		try (OutputStream os = response.getOutputStream()) {
			PdfRendererBuilder builder = new PdfRendererBuilder();
			builder.withHtmlContent(TemplatesHtml.getTemplate1(persons), null);
			builder.toStream(os);
			builder.run();
			os.close();
		}
	}

	public void template2(HttpServletResponse response, List<Person> persons) throws FileNotFoundException, IOException {
		PDDocument document = new PDDocument();
		int personsSize = persons.size();

		int index = 0;

		for (int i = 0; i < (persons.size() / 5 + 1); i++) {
			System.out.println("Outer - " + i);

			PDPage page = new PDPage(PDRectangle.A4);
			document.addPage(page);

			PDPageContentStream contentStream = new PDPageContentStream(document, page);
			PDFont font = PDType1Font.HELVETICA_BOLD;
			contentStream.setFont(font, 12);

			int margin = 50;
			float yPosition = page.getMediaBox().getHeight();

			int end = 5;

			System.out.println("End - " + end);
			System.out.println("Person Size - " + personsSize);

			int j = Math.min(end, personsSize);

			System.out.println("J - " + j);

			for (int start = 0; start < j; start++) {
				System.out.println("Inner - " + start);
				Person person = persons.get(index++);

				contentStream.beginText();
				yPosition -= 20;
				contentStream.newLineAtOffset(margin, yPosition);
				contentStream.showText("Id : " + person.getId());
				yPosition -= 20;
				contentStream.newLineAtOffset(0, -20);
				contentStream.showText("Name : " + person.getName());
				yPosition -= 20;
				contentStream.newLineAtOffset(0, -20);
				contentStream.showText("Phone : " + person.getPhone());
				yPosition -= 20;
				contentStream.newLineAtOffset(0, -20);
				contentStream.showText("Address : " + person.getAddress());
				yPosition -= 20;
				contentStream.newLineAtOffset(0, -20);
				contentStream.showText("Gender : " + person.getGender());
				contentStream.endText();
				yPosition -= 40;
				personsSize = Math.abs(personsSize - end);
			}

			contentStream.close();

		}

		OutputStream outputStream = response.getOutputStream();
		document.save(outputStream);
		outputStream.close();
		document.close();
	}

}
