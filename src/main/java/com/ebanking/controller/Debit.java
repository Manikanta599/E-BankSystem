package com.ebanking.controller;

import java.io.IOException;

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
		
		String accnum=request.getParameter("accno");
		System.out.println(accnum+"from page");
		HttpSession session=request.getSession();
		String accvalid="";
		String accnumber=(String) session.getAttribute("accno");
		String accnumus=accnum+"";
		System.out.println(accnumber+"from session");
		if(accnumus.equals(accnumber))
		{
			
			accvalid="yes";
			System.out.println("yes acc");
			/*session.setAttribute("accvalid", accvalid);
			RequestDispatcher rd=request.getRequestDispatcher("debit.jsp");
			rd.forward(request, response);*/
			
		}
		else
		{
			accvalid="no";
			/*RequestDispatcher rd=request.getRequestDispatcher("debit.jsp");
			rd.forward(request, response);*/
			System.out.println("not valid acc number");
		}
		
		
		// Set accvalid attribute in session
        session.setAttribute("accvalid", accvalid);
        
        // Forward the request to debit.jsp
        RequestDispatcher rd = request.getRequestDispatcher("debit.jsp");
        rd.forward(request, response);
		
	}
	
	

}
