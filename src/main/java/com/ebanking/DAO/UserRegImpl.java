package com.ebanking.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.omg.CORBA.UserException;

import com.ebanking.model.Bankuserdetails;

public class UserRegImpl implements UserRegDAO {
	
	Connection connection;
	private final String url="jdbc:mysql://localhost:3306/banking_pro?user=root&password=root";
	private final String userReg="insert into bankuserdetails(User_name,User_emailid,User_MobileNumber,User_Password,"
			+ "Accountnumber,IFSC_code,Address,Amount) values (?,?,?,?,?,?,?,?)";
	


	public boolean userRegistration(Bankuserdetails bankUserDetails) {
		
		
		 int user_id =bankUserDetails.getUser_id();
		 String user_name=bankUserDetails.getUser_name();
		 String user_emailid=bankUserDetails.getUser_emailid();
		 String user_MobileNumber=bankUserDetails.getUser_MobileNumber();
		 String user_Password=bankUserDetails.getUser_Password();
		 long accn=generateAccNumber();
		 
		 String accountnumber=accn+"";
		 String ifsc_code=bankUserDetails.getIfsc_code();
		 String address=bankUserDetails.getAddress();
		 double amount=bankUserDetails.getAmount();
		 
		 System.out.println(accountnumber);
		 
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url);
			
			PreparedStatement pst=connection.prepareStatement(userReg);
			pst.setString(1, user_name);
			pst.setString(2, user_emailid);
			pst.setString(3, user_MobileNumber);
			pst.setString(4, user_Password);
			pst.setString(5, accountnumber);
			pst.setString(6, "TECA540009");
			pst.setString(7, address);
			pst.setDouble(8, amount);
			
			int res=pst.executeUpdate();
			
			if(res>0)
			{
				System.out.println("updated..");
				return true;
			}
			else
			{
				return false;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			try {
//				connection.close();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return false;
 
	}

	
	
		
	private long generateAccNumber()
	{
		
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection=DriverManager.getConnection(url);
				Statement st = connection.createStatement();
			
			String query="SELECT Accountnumber FROM bankuserdetails ORDER BY account_number DESC LIMIT 1";
			ResultSet rs=st.executeQuery(query);
			
			if(rs.next())
			{
				long last_acc_num=rs.getLong("account_number");
				return last_acc_num+1;
			}
			else
			{
				return 1000000;
			}

	}
		catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return 1000000;
	
	}

}
