<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Enter Account number</h1>

<form action="debit" method="post">



<%
HttpSession session1 =request.getSession();

String accvalid=(String) session1.getAttribute("accvalid");

System.out.println(accvalid+"in accvalid");

if(accvalid != null && accvalid.equals("yes"))
{
	System.out.println("acc");
	%>
	<form action="debit" method="post">
	<input type="text" placeholder="Enter Debited Amount" name="amo">
	<input type="submit" value="Submit"> 
	</form>
	
	<%
	
	
}
else if(accvalid != null && accvalid.equals("no"))
{
	System.out.println("amo");
	System.out.println("else");
	%>
	<form action="debit" method="post">
	<input type="text" placeholder="Enter Your Account Number" name="accno">
	<input type="submit" value="Submit"> 
	</form>
	<%
	
}




%>



</form>

</body>
</html>