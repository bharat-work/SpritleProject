<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Tasks</title>
</head>
<body>

<h1>All tasks for You:</h1>
	
	<table border="1">
		<thead>
			<tr>
				<th>Student Name</th>
				<th>Left Operand</th>
				<th>Operator</th>
				<th>Right Operand</th>
				<th>Actions</th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach var="task" items="${tasks}">
			<tr>
				<td>${task.getStudentOrMasterName()}</td>
				<td>${task.getLeft()}</td>
				<td>${task.getOperation()}</td>
				<td>${task.getRight()}</td>
				<td><a href="/solveTask">Solve</a></td>
			</tr>
		</c:forEach>	
		</tbody>
	
	
	</table>



</body>
</html>