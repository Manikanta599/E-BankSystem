<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="changePassword" method="post">

<label>Enter Old Password:</label><br>
<input type="password" placeholder="Old password" name="oldpass"><br><br>

<input type="submit" value="submit"><br>
</form>

<%
String valid = (String) session.getAttribute("p_valid");

if (valid != null && valid.equals("yes")) {
	valid="";
%>

<form action="updatePassword" method="post">

<label>Enter new Password:</label><br>
<input type="password" placeholder="new Password" name="newpass1"><br>

<label>Please Enter new Password Again:</label><br>
<input type="password" placeholder="new Password" name="newpass2"><br><br>

<input type="submit">
	
	</form>
	<%
}

%>






</body>
</html>