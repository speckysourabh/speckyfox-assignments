<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/Export-Import-Data/import" enctype="multipart/form-data">
		<div>
			<label>Select a file to upload :</label> <input type="file" name="file" />
		</div>
		<input type="submit">
	</form>
</body>
</html>