package ORM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import Data.AccountType;

public class AccountTypeDB {
	
	public static boolean add(AccountType accountType){
		boolean rowAdded = true;
		try{
			
			PreparedStatement stmt = null;
			Connection conn = null;
			
			Class.forName("org.h2.Driver");
			
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/BudgetID", "decker233", "sammy");
			
			String sql = "INSERT INTO Account_Type (Account_Type_ID, Account_Type_Name, Asset) VALUES (?, ?, ?)";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, accountType.accountTypeID);
			stmt.setString(2, accountType.accountTypeName);
			stmt.setBoolean(3, accountType.asset);
			
			stmt.executeUpdate();
			conn.close();
			
		}catch (Exception e){
			System.out.println("There was a problem adding data in AccountTypeDB: "+ e);
			rowAdded = false;
		}
		return rowAdded;
	}
	
	public static boolean remove(AccountType accountType){
		boolean rowRemoved = true;
		try{
			
			PreparedStatement stmt = null;
			Connection conn = null;
			
			Class.forName("org.h2.Driver");
			
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/BudgetID", "decker233", "sammy");
			
			String sql = "DELETE FROM Account_Type WHERE Account_Type_ID =?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, accountType.accountTypeID);
			
			stmt.executeUpdate();
			conn.close();
			
		}catch (Exception e){
			System.out.println("There was a problem removing data in AccountTypeDB: "+ e);
			rowRemoved = false;
		}
		return rowRemoved;
	}
	
	public static boolean update(AccountType accountType){
		boolean rowUpdated = true;
		try{
			
			PreparedStatement stmt = null;
			Connection conn = null;
			
			Class.forName("org.h2.Driver");
			
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/BudgetID", "decker233", "sammy");
			
			String sql = "UPDATE Account_Type SET Account_Type_Name=?, Asset=? WHERE Account_Type_ID=?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, accountType.accountTypeName);
			stmt.setBoolean(2, accountType.asset);
			stmt.setInt(3, accountType.accountTypeID);
			
			stmt.executeUpdate();
			conn.close();
			
		}catch (Exception e){
			System.out.println("There was a problem updating data in AccountTypeDB: "+ e);
			rowUpdated = false;
		}
		return rowUpdated;
	}
}
