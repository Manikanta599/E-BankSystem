package com.ebanking.model;

public class Bankuserdetails {
	
	private int user_id;
	private String user_name;
	private String user_emailid;
	private String user_MobileNumber;
	private String user_Password;
	private String accountnumber;
	private String ifsc_code;
	private String address;
	private double amount;
	
	
	public Bankuserdetails() {
		
	}


	public Bankuserdetails(int user_id, String user_name, String user_emailid, String user_MobileNumber,
			String user_Password, String accountnumber, String ifsc_code, String address, double amount) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_emailid = user_emailid;
		this.user_MobileNumber = user_MobileNumber;
		this.user_Password = user_Password;
		this.accountnumber = accountnumber;
		this.ifsc_code = ifsc_code;
		this.address = address;
		this.amount = amount;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getUser_emailid() {
		return user_emailid;
	}


	public void setUser_emailid(String user_emailid) {
		this.user_emailid = user_emailid;
	}


	public String getUser_MobileNumber() {
		return user_MobileNumber;
	}


	public void setUser_MobileNumber(String user_MobileNumber) {
		this.user_MobileNumber = user_MobileNumber;
	}


	public String getUser_Password() {
		return user_Password;
	}


	public void setUser_Password(String user_Password) {
		this.user_Password = user_Password;
	}


	public String getAccountnumber() {
		return accountnumber;
	}


	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}


	public String getIfsc_code() {
		return ifsc_code;
	}


	public void setIfsc_code(String ifsc_code) {
		this.ifsc_code = ifsc_code;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "Bankuserdetails [user_id=" + user_id + ", user_name=" + user_name + ", user_emailid=" + user_emailid
				+ ", user_MobileNumber=" + user_MobileNumber + ", user_Password=" + user_Password + ", accountnumber="
				+ accountnumber + ", ifsc_code=" + ifsc_code + ", address=" + address + ", amount=" + amount + "]";
	}
	
	
	
	
	

}
