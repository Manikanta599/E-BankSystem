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

@WebServlet("/changePassword")
public class ChangePassword extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String oldPin=request.getParameter("oldpass");
		System.out.println(oldPin+"from user");
		HttpSession session=request.getSession();
		PrintWriter pw=response.getWriter();
		String pin=(String) session.getAttribute("pass");
		System.out.println(pin+"from db");
		String Pvalid="";
		
		if(oldPin.equals(pin))
		{
			Pvalid="yes";
			session.setAttribute("p_valid", Pvalid);
			RequestDispatcher rs=request.getRequestDispatcher("changePassword.jsp");
			rs.forward(request, response);
		}
		else
		{
			Pvalid="no";
			session.setAttribute("p_valid", Pvalid);
			RequestDispatcher rs=request.getRequestDispatcher("changePassword.jsp");
			pw.println("invalid old pin");
			rs.include(request, response);
			
			
		}
		
	}

}
