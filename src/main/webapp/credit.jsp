<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Credit Transaction</h2>

    <form action="credit" method="post">
        <input type="text" placeholder="Enter Your Account Number" name="accno">
        <input type="submit" value="Submit">
    </form>
    
    <%
    
    
    String status = (String) session.getAttribute("credit_validation");
    
    System.out.println(status+"credit status");
    if (status != null && status.equals("yes")) {
    	
    %>
        <form action="creditAmount" method="post">
            <input type="text" placeholder="Enter Your Amount" name="amount">
            <input type="submit" value="Submit">
        </form>
        
        
    <%
    
    } 
    else 
    {
        out.println("Invalid Account Number");
    }
    %>
    
    

</body>
</html>