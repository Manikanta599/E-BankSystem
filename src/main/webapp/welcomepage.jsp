<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
        /* Paste the CSS styles here */
        * {
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }

        body {
            width: 100%;
            height: 100vh;
           
            background-image:url("17454.jpg");
            background-repeat:no-repeat;
            background-size:100% 100%;
            display: flex;
            justify-content: center;
            align-items: center;
            position: relative; /* Added position relative to make position:absolute of child elements work */
        }

        h3 {
            position: absolute;
            right: 50px;
            top: 0;
            margin: 0;
            color: #fff;
        }

        h3:nth-of-type(2) {
            top: 25px;
        }

        .container {
            width: 80%;
            max-width: 600px;
        }

        .buttons {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            margin-top: 50px; /* Adjust as needed */
        }

        .buttons a {
            width: 45%;
            text-align: center;
            text-decoration: none;
            color: #fff;
            background-color: purple;
            border-radius: 5px;
            padding: 15px 0;
            margin-bottom: 15px;
            transition: background-color 0.3s;
            border: 5px solid blue;
        }

        .buttons a:hover {
            background-color: #45a049;
        }

        input[type="submit"] {
            width: 100%;
            height: 100%;
            cursor: pointer;
            border: none;
            background: none;
           
        }
        input
        {
        	font-style: italic;
        	font-weight: bold;
        }
        #acc
        {
        display: none;
        }
        
        #name:hover #acc { /* Changed #acc:hover to #name:hover #acc */
    display: block;
  }
        
    </style>
    
    
    
<body >

<h1 style="position: absolute;top: 15px; color: red;">WELCOME PAGE</h1>

<%
HttpSession session1 = request.getSession();
String name = (String) session1.getAttribute("name");
String accno = (String) session1.getAttribute("accno");

String sub = accno.substring(0, 2) + "***" + accno.substring(5, 7);


if (name != null) {
%>
  <div id="name">
  <h3 style="position: absolute; right: 50px;top: 0px;">welcome:-<%=name%></h3>
<h3 style="position: absolute; right: 50px;top: 25px;" id="acc">Acc_No:-<%=sub%></h3>
</div>

<% 
}
%>






<div class="container">
<div class="buttons">
<a href="debit.jsp"><input type="submit" value="Withdraw "></a>
<a href="credit.jsp"><input type="submit" value="Credit Amount"></a></div>
<div class="buttons">

<a href="statement.jsp"><input type="submit" value="Check Statement"></a>
<a href=""><input type="submit" value="Change password"></a>
</div>
</div>
</body>
</html>
