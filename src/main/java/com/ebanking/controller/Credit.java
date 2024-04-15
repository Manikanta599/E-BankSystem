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
@WebServlet("/credit")
public class Credit extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accno=request.getParameter("accno");
		System.out.println(accno);
		HttpSession session=request.getSession();
		PrintWriter writer=response.getWriter();
		
		String login_acc=(String) session.getAttribute("accno");
		System.out.println(accno+"from user");
		System.out.println(login_acc+"from login");
		String credit_validation="";
		if(accno.equals(login_acc))
		{
			System.out.println("valid credit ..");
			credit_validation="yes";
			session.setAttribute("credit_validation", credit_validation);
			RequestDispatcher rd=request.getRequestDispatcher("credit.jsp");
			rd.forward(request, response);
			
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("credit.jsp");
			rd.include(request, response);
			writer.println("invalid Account Number");
			session.setAttribute("credit_validation", credit_validation);
			System.out.println("not valid account number");
		}
		
	}

}
