package com.ebanking.DAO;

import com.ebanking.model.Bankuserdetails;

public interface UserRegDAO {
	
	boolean userRegistration(Bankuserdetails bankUserDetails);
	Bankuserdetails UserLogin(String password,String email);
	

}


//agge jnxo btgs zism
