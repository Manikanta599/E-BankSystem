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
<h2>Debit Transaction</h2>

    <form action="debit" method="post">
        <input type="text" placeholder="Enter Your Account Number" name="acc">
        <input type="submit" value="Submit">
    </form>
    
    <%
    String status = (String) session.getAttribute("msg");
    
    System.out.println(status);
    if (status != null && status.equals("yes")) {
    %>
        <form action="amountvalidation" method="post">
            <input type="text" placeholder="Enter Your Amount" name="amount">
            <input type="submit" value="Submit">
        </form>
        
        
    <%
    
    } else 
    {
        out.println("Invalid Account Number");
    }
    %>
</center>
</body>
</html>