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

@WebServlet("/updatePassword")
public class NewPasswordSetting extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pass1=request.getParameter("newpass1");
		String pass2=request.getParameter("newpass2");
		
		HttpSession session=request.getSession();
		PrintWriter pw=response.getWriter();
		String pin=(String) session.getAttribute("pass");
		
		if(pass1.equals(pin))
		{
			pw.println("new password cannot be same as old password");
			RequestDispatcher rd=request.getRequestDispatcher("changepassword.jsp");
			rd.include(request, response);
		}
		else
		{
			if(pass1.equals(pass2))
			{
				pw.println("updated sucessfully");
				System.out.println("updated sucessfully");
			}
			else
			{
				pw.println("password does not match");
				RequestDispatcher rd=request.getRequestDispatcher("changepassword.jsp");
				rd.include(request, response);
			}
		}
	}

}
