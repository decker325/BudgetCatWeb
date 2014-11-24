package ORM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Map;

import Data.Account;

public class AccountDB {
	
	public static boolean add(Account account){
		boolean rowAdded = true;
		try{
			
			PreparedStatement stmt = null;
			Connection conn = null;
			
			Class.forName("org.h2.Driver");
			
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/BudgetID", "decker233", "sammy");
			
			String sql = "INSERT INTO ACCOUNT (Account_ID, User_ID, Account_Name, Account_Type_ID, Balance, Balance_Goal, Interest_Amount, Notes) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, account.accountID);
			stmt.setInt(2, account.userID);
			stmt.setString(3, account.accountName);
			stmt.setInt(4, account.accountTypeID);
			stmt.setDouble(5, account.balance);
			stmt.setDouble(6, account.balanceGoal);
			stmt.setDouble(7, account.interestAmount);
			stmt.setString(8, account.notes);
			
			stmt.executeUpdate();
			conn.close();
			
		}catch (Exception e){
			System.out.println("There was a problem adding data in AccountDB: "+ e);
			rowAdded = false;
		}
		return rowAdded;
	}
	
	public static boolean remove(Account account){
		boolean rowRemoved = true;
		try{
			
			PreparedStatement stmt = null;
			Connection conn = null;
			
			Class.forName("org.h2.Driver");
			
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/BudgetID", "decker233", "sammy");
			
			String sql = "DELETE FROM ACCOUNT WHERE Account_ID=?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, account.accountID);
			
			stmt.executeUpdate();
			conn.close();
			
		}catch (Exception e){
			System.out.println("There was a problem removing data in AccountDB: "+ e);
			rowRemoved = false;
		}
		return rowRemoved;
	}
	
	public static boolean update(Account account){
		boolean rowUpdated = true;
		try{
			
			PreparedStatement stmt = null;
			Connection conn = null;
			
			Class.forName("org.h2.Driver");
			
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/BudgetID", "decker233", "sammy");
			
			String sql = "UPDATE Account SET User_ID=?, Account_Name=?, Account_Type_ID=?, Balance=?, Balance_Goal=?, Interest_Amount=?, Notes WHERE Account_ID=?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, account.userID);
			stmt.setString(2, account.accountName);
			stmt.setInt(3, account.accountTypeID);
			stmt.setDouble(4, account.balance);
			stmt.setDouble(5, account.balanceGoal);
			stmt.setDouble(6, account.interestAmount);
			stmt.setString(7, account.notes);
			stmt.setInt(8, account.accountID);
			
			stmt.executeUpdate();
			conn.close();
			
		}catch (Exception e){
			System.out.println("There was a problem updating data in AccountDB: "+ e);
			rowUpdated = false;
		}
		return rowUpdated;
	}
}
