package com.ebanking.DAO;

import java.util.List;

import com.ebanking.model.BankStatement;
import com.ebanking.model.Bankuserdetails;

public interface UserRegDAO {
	
	boolean userRegistration(Bankuserdetails bankUserDetails);
	Bankuserdetails UserLogin(String password,String email);
	 boolean debitAmount(BankStatement bankStatement);
	 boolean creditAmount(BankStatement bankStatement);
	 
	 List<BankStatement> getAllTransactions(String accno);
	 
	 boolean updatePassword(String accno,String pin);
	 
	
	

}


//agge jnxo btgs zism
