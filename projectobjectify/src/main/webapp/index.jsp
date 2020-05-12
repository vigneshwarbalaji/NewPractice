<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Objectify App</title>
</head>
<body>
<h3>User App</h3>

<p id = "name"></p>

<h4>Create User</h4>

Name:<br>
<input type = "text" id = "nameId" name = "name"><br>
Email:<br>
<input type = "text" id = "emailId" name = "email"><br><br>
<button id = "buttonOne" name="createUser" onclick="createFunc()">Create User</button>

<script src="js/User.js"></script>
</body>
</html>