<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<center>

<h1>User Registration</h1>

<form action="userreg" method="post">

<input type="text" placeholder="Enter Your Name" name="name"> <br><br>
<input type="text" placeholder="Enter Your Email" name="email"> <br><br>
<input type="text" placeholder="Enter Your Mobile Num" name="mob"> <br><br>
<input type="password" placeholder="Enter Your Password" name="pass"> <br><br>
<input type="text" placeholder="Enter Your Address" name="add"> <br><br>
<input type="text" placeholder="Enter Amount" name="amo" required="required"><br><br>


<input type="submit" value="Registration"><br><br>


</form>



</center>



</body>
</html>