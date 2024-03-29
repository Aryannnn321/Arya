<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="text_align:right">
<a href="admin">Admin</a><br>
</div>
<form action="search">
enter Speciality
<input type="text" name="choice"><br>
<input type="submit" value="search"><br>
</form>
<h2>All doctors</h2>
${doctors }
<h2 style="{color:red;}">${message }</h2>
</body>
</html>