<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Master Task Page</title>
</head>
<body>

<div>
<h1>Welcome To Your DashBoard : Master Name</h1>

<h1>Master Create the Task</h1>

<form action="task_creation" method="post">

<div hidden>
	<input type="number" value="${id}" name="masterId" />
</div>

<label for="fn">First Number:</label>
<select name="fn">
	<option value="zero">zero</option>
	<option value="one">one</option>
	<option value="two">two</option>
	<option value="three">three</option>
	<option value="four">four</option>
	<option value="five">five</option>
	<option value="six">six</option>
	<option value="seven">seven</option>
	<option value="eight">eight</option>
	<option value="nine">nine</option>
</select>

<br>

<label for="sn">Second Number:</label>
<select name="sn">
	<option value="zero">zero</option>
	<option value="one">one</option>
	<option value="two">two</option>
	<option value="three">three</option>
	<option value="four">four</option>
	<option value="five">five</option>
	<option value="six">six</option>
	<option value="seven">seven</option>
	<option value="eight">eight</option>
	<option value="nine">nine</option>
</select>

<br>

<label for="operation">Select Operation:</label>
<select name="operation">
	<option value="plus">plus</option>
	<option value="minus">minus</option>
	<option value="times">times</option>
	<option value="divided_by">divided_by</option>
</select>

<br>

<label for="student_assigned">Assign Student: </label>
<select name="student_assigned">
	<option value="--select--">--select--</option>
<c:forEach var="i" items="${values}">
	<option value="${i}">${i}</option>
</c:forEach>
	
</select>

<br>

<input type="submit" value="Assign Task" />


</form>

<br>

<form action="displayMasterTasks">

<div hidden>
	<input type="number" value="${id}" name="masterId" />
</div>
<input type="submit" value="See All Tasks Assigned" />

</form>

</div>
</body>
</html>