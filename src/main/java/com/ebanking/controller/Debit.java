package com.ebanking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/debit")
public class Debit extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account=request.getParameter("acc");
		
		HttpSession session=request.getSession();
		String account2=(String)session.getAttribute("accno");
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		
		System.out.println(account+"from user");
		System.out.println(account2+"from login");
		if(account.equals(account2))
		{
			session.setAttribute("msg","yes");
			RequestDispatcher rd=request.getRequestDispatcher("debit.jsp");
			rd.forward(request, response);
			System.out.println("valid");
		}
		else {
			session.setAttribute("msg","no");
			RequestDispatcher rd=request.getRequestDispatcher("debit.jsp");
			rd.forward(request, response);
			System.out.println("not valid");
		}
	}

}