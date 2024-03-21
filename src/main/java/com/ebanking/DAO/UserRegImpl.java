package com.ebanking.DAO;

import com.ebanking.model.Bankuserdetails;

public class UserRegImpl implements UserRegDAO {

	public void userRegistration(Bankuserdetails bankUserDetails) {
		
		 int user_id =bankUserDetails.getUser_id();
		 String user_name=bankUserDetails.getUser_name();
		 String user_emailid=bankUserDetails.getUser_emailid();
		 String user_MobileNumber=bankUserDetails.getUser_MobileNumber();
		 String user_Password=bankUserDetails.getUser_Password();
		 String accountnumber=bankUserDetails.getAccountnumber();
		 String ifsc_code=bankUserDetails.getIfsc_code();
		 String address=bankUserDetails.getAddress();
		 double amount=bankUserDetails.getAmount();
		 
		 
	}
	

}
