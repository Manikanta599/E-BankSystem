package com.ebanking.model;

import java.sql.Date;
import java.sql.Time;

public class BankStatement {
	
	private int transection_id;
	private Date data_of_Transection;
	private Time time_of_transcation;
	private String transection_type;
	private String  transcation_amount;
	private double balance;
	private String bank_AccountNumber;
	private int user_id;
	
	public BankStatement() {
		super();
	}
	
	
	public BankStatement(int transection_id, Date data_of_Transection, Time time_of_transcation,
			String transection_type, String transcation_amount, double balance, String bank_AccountNumber,
			int user_id) {
		//super();
		this.transection_id = transection_id;
		this.data_of_Transection = data_of_Transection;
		this.time_of_transcation = time_of_transcation;
		this.transection_type = transection_type;
		this.transcation_amount = transcation_amount;
		this.balance = balance;
		this.bank_AccountNumber = bank_AccountNumber;
		this.user_id = user_id;
	}


	public int getTransection_id() {
		return transection_id;
	}


	public void setTransection_id(int transection_id) {
		this.transection_id = transection_id;
	}


	public Date getData_of_Transection() {
		return data_of_Transection;
	}


	public void setData_of_Transection(Date data_of_Transection) {
		this.data_of_Transection = data_of_Transection;
	}


	public Time getTime_of_transcation() {
		return time_of_transcation;
	}


	public void setTime_of_transcation(Time time_of_transcation) {
		this.time_of_transcation = time_of_transcation;
	}


	public String getTransection_type() {
		return transection_type;
	}


	public void setTransection_type(String transection_type) {
		this.transection_type = transection_type;
	}


	public String getTranscation_amount() {
		return transcation_amount;
	}


	public void setTranscation_amount(String transcation_amount) {
		this.transcation_amount = transcation_amount;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public String getBank_AccountNumber() {
		return bank_AccountNumber;
	}


	public void setBank_AccountNumber(String bank_AccountNumber) {
		this.bank_AccountNumber = bank_AccountNumber;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	



	

}
