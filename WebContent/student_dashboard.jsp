<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tasks Assigned</title>
</head>
<body>

<h1>Welcome To Your DashBoard : Student Name</h1>

<form action="tasksAssigned" >

<div hidden>
	<input type="number" value="${id}" name="studentId" />
</div>

<input type="submit" value="show my tasks" >

</form>


</body>
</html>