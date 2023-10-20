package com.sft.utils;

import java.util.List;

import com.sft.pojo.Person;

public class TemplatesHtml {

	public static String getTemplate1(List<Person> persons) {
		
		StringBuilder builder = new StringBuilder();
		builder.append("<html>");
		builder.append("<head>");
		builder.append("<style> table { border: 1px solid red } </style>");
		builder.append("</head>");
		builder.append("<body>");
		builder.append("<h1>Person Details</h1>");
		builder.append("<table>");
		for(Person person: persons) {
			builder.append("<tr>");
			builder.append("<td>"+person.getId()+"</td>");
			builder.append("<td>"+person.getName()+"</td>");
			builder.append("<td>"+person.getPhone()+"</td>");
			builder.append("<td>"+person.getAddress()+"</td>");
			builder.append("<td>"+person.getGender()+"</td>");
			builder.append("</tr>");
		}
		builder.append("</table>");
		builder.append("</body>");
		builder.append("</html>");
		
		return builder.toString();
	}
	
}
