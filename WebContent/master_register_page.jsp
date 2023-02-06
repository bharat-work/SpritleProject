<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
	<title>Master Registration</title>
</head>
<body>



<div>

<h1>Master Registration Page</h1>
<form action="master_register" method="post">

<label for="name">Name:</label>
<input type="text" name="name" placeholder="enter your name" />
<br>

<label for="email">email:</label>
<input type="email" name="email" placeholder="enter your email" />
<br>


<label for="mobile">mobile:</label>
<input type="tel" name="mobile" placeholder="enter your mobile" />
<br>


<label for="pass">password:</label>
<input type="password" name="pass" placeholder="set your password" />
<br>

<input type="submit" value="Register" />

</form>
</div>
	
</body>
</html>