<%@page import="com.ebanking.model.BankStatement"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h1>Transaction Data</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Transaction ID</th>
                <th>Date of Transaction</th>
                <th>Transaction Type</th>
                <th>Transaction Amount</th>
                <th>Balance</th>
                <th>Time of Transaction</th>
                <th>Bank Account Number</th>
                <th>User ID</th>
            </tr>
        </thead>
        <tbody>
<% 
    List<BankStatement> transactions = (List<BankStatement>) session.getAttribute("transactions");
    for (BankStatement transaction : transactions) { 
%>                <tr>
                    <td><%= transaction.getTransection_id() %></td>
                    <td><%= transaction.getData_of_Transection() %></td>
                    <td><%= transaction.getTransection_type() %></td>
                    <td><%= transaction.getTranscation_amount() %></td>
                    <td><%= transaction.getBalance() %></td>
                    <td><%= transaction.getTime_of_transcation() %></td>
                    <td><%= transaction.getBank_AccountNumber() %></td>
                    <td><%= transaction.getUser_id() %></td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>