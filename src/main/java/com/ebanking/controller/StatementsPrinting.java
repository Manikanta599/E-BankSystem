package com.ebanking.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ebanking.DAO.UserRegDAO;
import com.ebanking.DAO.UserRegImpl;
import com.ebanking.model.BankStatement;

import java.util.*;

@WebServlet("/statement")
public class StatementsPrinting extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserRegDAO user=(UserRegDAO) new UserRegImpl();
		
		
		
		HttpSession session=request.getSession();
		
		
		
		String accno= (String) session.getAttribute("accno");
		
		
		List<BankStatement> trans= user.getAllTransactions(accno);
		
		session.setAttribute("transactions", trans);
		
		for(BankStatement b:trans)
		{
			System.out.println(b.getTransection_type());
		}
		
		if(trans.size()>0)
		{
			RequestDispatcher req=request.getRequestDispatcher("statement.jsp");
			req.forward(request, response);
		}
		else
		{
			System.out.println("empty");
		}
	}
}
