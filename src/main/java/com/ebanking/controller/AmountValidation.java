package com.ebanking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
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

@WebServlet("/amountvalidation")

public class AmountValidation extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String tempUserAmount=request.getParameter("amount");
		double userAmount=Double.parseDouble(tempUserAmount);
		HttpSession session=request.getSession();
		Double userBankAmount=(Double) session.getAttribute("userBankAmount");	
		PrintWriter pw=response.getWriter();
		
		System.out.println(tempUserAmount+"form user");

		System.out.println(userBankAmount+"form db");
		
		response.setContentType("text/html");
		
		//HttpSession session=request.getSession();
		
		UserRegDAO userreg=(UserRegDAO)new UserRegImpl();
		
		if(userAmount>0)
		{
			if(userBankAmount>=userAmount)
			{
				System.out.println("ok");
				
				double balanceamount=userBankAmount-userAmount;
				
				BankStatement bankstatement=new BankStatement();
				bankstatement.setData_of_Transection(Date.valueOf(LocalDate.now()));
				bankstatement.setTime_of_transcation(Time.valueOf(LocalTime.now()));
				bankstatement.setTranscation_amount(userAmount+"");
				bankstatement.setBalance(balanceamount);
				String acc=(String) session.getAttribute("accno");
				bankstatement.setBank_AccountNumber(acc);
				bankstatement.setTransection_type("Debit");
				Integer userid=(Integer) session.getAttribute("userid");
				bankstatement.setUser_id(userid);
				
				boolean status=userreg.debitAmount(bankstatement);
				
				if(status)
				{
					pw.println("<center><h1>Withdraw Sucessfull!1</h1></center>");
				}
				else
				{
					pw.println("<center><h1>Withdraw Not Sucessfull!1</h1></center>");
				}
			
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("debit.jsp");
				rd.include(request, response);
				pw.println("insufficient balance");
			}
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("debit.jsp");
			rd.include(request, response);
			pw.println("enter valid amount");
		}
		
		
		
	}

}
