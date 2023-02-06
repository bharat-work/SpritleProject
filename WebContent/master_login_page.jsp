<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>

<div>

<h1>Master Login</h1>
<form action="master_login" method="post">

<label for="email">email:</label>
<input type="email" name="email" placeholder="enter your email" />
<br>

<label for="password">password:</label>
<input type="password" name="pass" placeholder="enter your password" />
<br>

<input type="submit" value="login" />

</form>
</div>

</body>
</html>