package com.ebanking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.coyote.http11.upgrade.UpgradeServletOutputStream;

import com.ebanking.DAO.UserRegDAO;
import com.ebanking.DAO.UserRegImpl;
import com.ebanking.model.Bankuserdetails;
@WebServlet("/login")

public class UserLogin extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		System.out.println(email);
		System.out.println(pass);
		PrintWriter pw=response.getWriter();
		
		
		UserRegDAO userlog=new UserRegImpl();
		//String res=userlog.UserLogin(pass, email);
		HttpSession session=request.getSession();
		
		Bankuserdetails userlogin=userlog.UserLogin(pass, email);
		
		
		
		if(userlogin!=null)
		{
			session.setAttribute("name", userlogin.getUser_name());
			session.setAttribute("accno", userlogin.getAccountnumber());
			session.setAttribute("userBankAmount", userlogin.getAmount());
			session.setAttribute("userid", userlogin.getUser_id());
			session.setAttribute("pass", userlogin.getUser_Password());
			System.out.println("login success");
			RequestDispatcher rd=request.getRequestDispatcher("welcomepage.jsp");
			rd.forward(request, response);
			
			
			
		}
		else
		{
			System.out.println("invalid..");
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
			pw.println("</center></h1>Please provide valid details</center></h1>");
		}
		
		
		
		
	}

}
