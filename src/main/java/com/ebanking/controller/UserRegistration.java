package com.ebanking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebanking.DAO.UserRegDAO;
import com.ebanking.DAO.UserRegImpl;
import com.ebanking.model.Bankuserdetails;
@WebServlet("/userreg")

public class UserRegistration extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("pass");
		String mobn=request.getParameter("mob");
		String add=request.getParameter("add");
		
		Bankuserdetails bankUserDet=new Bankuserdetails();
		
		bankUserDet.setUser_name(username);
		bankUserDet.setUser_emailid(email);
		bankUserDet.setUser_Password(password);
		bankUserDet.setUser_MobileNumber(mobn);
		bankUserDet.setAddress(add);
		
		System.out.println(bankUserDet.getAddress());
		
		UserRegDAO userReg=new UserRegImpl();
		
		PrintWriter pw=response.getWriter();
		
		if(userReg.userRegistration(bankUserDet))
		{
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			
			
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("UserRegistration.jsp");
			rd.include(request, response);
			pw.println("</center></h1>Please provide valid details</center></h1>");
			
		}
		
		
		
	}

}
