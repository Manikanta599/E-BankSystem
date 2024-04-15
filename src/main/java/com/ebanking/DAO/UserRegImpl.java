package com.ebanking.DAO;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.*;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import org.apache.el.parser.BooleanNode;
import org.omg.CORBA.UserException;

import com.ebanking.model.BankStatement;
import com.ebanking.model.Bankuserdetails;
import com.mysql.cj.Session;

public class UserRegImpl implements UserRegDAO {
	
	Connection connection;
	private final String url="jdbc:mysql://localhost:3306/banking_pro?user=root&password=root";
	private final String userReg="insert into bankuserdetails(User_name,User_emailid,User_MobileNumber,User_Password,"
			+ "Accountnumber,IFSC_code,Address,Amount) values (?,?,?,?,?,?,?,?)";
	private final String login="SELECT Accountnumber FROM bankuserdetails ORDER BY Accountnumber DESC LIMIT 1";
	private final String insertStatemet="insert into statement (Data_of_Transection,Transection_type,"
			+ "Transcation_amount,Balance,Time_of_transcation,Bank_AccountNumber,User_id) values(?,?,?,?,?,?,?)";
	private final String updateamount="update bankuserdetails set Amount =?  where Accountnumber=?";
	
	private final String AllTrans="select * from statement where Bank_AccountNumber=?";
	
			 
	
	
	


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
			
			ResultSet rs=st.executeQuery(login);
			
			if(rs.next())
			{
				long last_acc_num=rs.getLong("Accountnumber");
				System.out.println("acc"+last_acc_num+1);
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




	public Bankuserdetails UserLogin(String password, String email) {
		
		
		//PrintWriter pw=response.getWriter();
		String query="select * from bankuserdetails where (User_emailid=? or User_MobileNumber=?) and User_Password=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking_pro?user=root&password=root");
			PreparedStatement pst=con.prepareStatement(query);
			
			pst.setString(1, email);
			pst.setString(2, email);
			pst.setString(3, password);
			
			
			ResultSet rs=pst.executeQuery();
			
			if(rs.next())
			{
				Bankuserdetails bankuserdetials=new Bankuserdetails();
				bankuserdetials.setUser_name(rs.getString("User_name"));
				bankuserdetials.setUser_emailid(rs.getString("User_emailid"));
				bankuserdetials.setUser_Password(rs.getString("User_Password"));
				bankuserdetials.setAccountnumber(rs.getString("Accountnumber"));
				bankuserdetials.setAmount(rs.getDouble("Amount"));
				bankuserdetials.setAddress(rs.getString("Address"));
				bankuserdetials.setUser_id(rs.getInt("User_id"));
				
				return bankuserdetials;
			}
			else
			{
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}




	public boolean debitAmount(BankStatement bankStatement) {
		
		
		try {
			connection=DriverManager.getConnection(url);
			PreparedStatement pst=connection.prepareStatement(updateamount);
			pst.setDouble(1, bankStatement.getBalance());
			pst.setString(2, bankStatement.getBank_AccountNumber());
			
			int res=pst.executeUpdate();
			
			if(res!=0)
			{
				System.out.println("debit amount updated");
				
				PreparedStatement pst1=connection.prepareStatement(insertStatemet);
				pst1.setDate(1, bankStatement.getData_of_Transection());	
				pst1.setString(2, bankStatement.getTransection_type());
				pst1.setString(3, bankStatement.getTranscation_amount());
				
				pst1.setDouble(4, bankStatement.getBalance());
				pst1.setTime(5, bankStatement.getTime_of_transcation());
				pst1.setString(6, bankStatement.getBank_AccountNumber());
				pst1.setInt(7, bankStatement.getUser_id());
				
				int res1=pst1.executeUpdate();   
				
				if(res1!=0)
				{
					System.out.println("debit statement updated");
					return true;
				}
				else
				{	
					System.out.println("debit statement not updated");
					return false;
				}
	
			}
			else
			{
				System.out.println("debit amont not updated");
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}




	public boolean creditAmount(BankStatement bankStatement) {
		
		try {
			connection=DriverManager.getConnection(url);
			
			PreparedStatement pst=connection.prepareStatement(updateamount);
			pst.setDouble(1, bankStatement.getBalance());
			pst.setString(2, bankStatement.getBank_AccountNumber());
			
			int res=pst.executeUpdate();
			
			if(res!=0)
			{
				System.out.println("credit amount updated");
				
				PreparedStatement pst1=connection.prepareStatement(insertStatemet);
				pst1.setDate(1, bankStatement.getData_of_Transection());	
				pst1.setString(2, bankStatement.getTransection_type());
				pst1.setString(3, bankStatement.getTranscation_amount());
				
				pst1.setDouble(4, bankStatement.getBalance());
				pst1.setTime(5, bankStatement.getTime_of_transcation());
				pst1.setString(6, bankStatement.getBank_AccountNumber());
				pst1.setInt(7, bankStatement.getUser_id());
				
				int res1=pst1.executeUpdate();   
				
				if(res1!=0)
				{
					System.out.println("credit statement updated");
					return true;
				}
				else
				{	
					System.out.println("credit statement not updated");
					return false;
				}
	
			}
			else
			{
				System.out.println(" credit amont not updated");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}


	
	public List<BankStatement> getAllTransactions(String accno) {
		
		List<BankStatement> transactions = new ArrayList<BankStatement>();
		
		try {
			connection=DriverManager.getConnection(url);
			
			PreparedStatement pst=connection.prepareStatement(AllTrans);
			
			
			pst.setString(1,accno);
			System.out.println(accno+" accno in impl");
			
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				
			
			
			while(rs.next())
			{
				System.out.println("count");
				BankStatement transaction=new BankStatement();
				transaction.setTransection_id(rs.getInt("Transection_id"));
                transaction.setData_of_Transection(rs.getDate("Data_of_Transection"));
                transaction.setTransection_type(rs.getString("Transection_type"));
                transaction.setTranscation_amount(rs.getString("Transcation_amount"));
                transaction.setBalance(rs.getDouble("Balance"));
                transaction.setTime_of_transcation(rs.getTime("Time_of_transcation"));
                transaction.setBank_AccountNumber(rs.getString("Bank_AccountNumber"));
                transaction.setUser_id(rs.getInt("User_id"));
                
                transactions.add(transaction);
				
			}
			}
			else
			{
				System.out.println("no transations");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return transactions;
	}
	
	
	
	

}
