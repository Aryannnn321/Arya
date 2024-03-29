<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addDoctor">
Enter Speciality
<select type="text" name="speciality">
<option value="ORTHO">ortho</option>
<option value="GYNAEC">gynaec</option>
<option value="PEADIC">peadic</option>
<option value="PHYSIO">physio</option>
</select>
Enter Fees
<input type="text" values="fees">
Enter Ratings
<input type="text" values="ratings">
enter doctorName
<input type="text" values="doctorName">
enter doctorId
<input type="text" values="doctorId">
Experience
<input type="text" values="experience">
<input type="submit" value="submit">
</form>
</body>
</html>