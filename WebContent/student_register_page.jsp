<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>

<div>

<h1>Student Registration Page</h1>
<form action="student_register" method="post">

<label for="name">Name:</label>
<input type="text" name="name" placeholder="enter student name" />
<br>

<label for="email">email:</label>
<input type="email" name="email" placeholder="enter student email" />
<br>

<label for="mobile">mobile:</label>
<input type="tel" name="mobile" placeholder="enter student mobile" />
<br>

<label for="pass">password:</label>
<input type="password" name="pass" placeholder="set student password" />
<br>

<input type="submit" value="Register" />

</form>
</div>

</body>
</html>