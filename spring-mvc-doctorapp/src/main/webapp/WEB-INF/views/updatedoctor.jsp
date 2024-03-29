<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updateDoctor">
	
	<input type="text" name="doctorName" value="${doctor.doctorName }">
	<input type="text" name="speciality" value="${doctor.speciality }">
	<input type="text" name="fees" value="${doctor.fees}">
	<input type="text" name="ratings" value="${doctor.ratings }">
	<input type="text" name="experience" value="${doctor.experience }">
	<input type="text" name="doctorId" value="${doctor.doctorId }">
	
</form>
</body>
</html>