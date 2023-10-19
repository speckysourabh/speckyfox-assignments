<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		for(String file: ((List<String>)request.getAttribute("files"))) {
	%>
	<div>
		<a href="/Export-Import-Data/download?fileName=<%= file %>"><%= file %></a>
	</div>
	<%
		}
	%>
</body>
</html>