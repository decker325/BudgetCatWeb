package ORM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Map;

public class AccountDB {
	public static boolean injectData(Map<String, String> map){
		boolean dataInjected = true;
		try{
			int accountID = Integer.parseInt(map.get("Account_ID"));
			int userID = Integer.parseInt(map.get("User_ID"));
			String accountName = map.get("Account_Name");
			int accountTypeID = Integer.parseInt(map.get("Account_Type_ID"));
			Double balance = Double.parseDouble(map.get("Balance"));
			Double balanceGoal = Double.parseDouble(map.get("Balance_Goal"));;
			Double interestAmount = Double.parseDouble(map.get("Interest_Amount"));;
			String notes = map.get("Notes");
			
			addAccountType(accountID, userID, accountName, accountTypeID, balance, balanceGoal, interestAmount, notes);
		}catch (Exception e){
			System.out.println("There was a problem injecting xml data in BudgetDB: "+ e);
			dataInjected = false;
		}
		return dataInjected;
	}
	
	public static boolean addAccountType(int accountID, int userID, String accountName,int accountTypeID, Double balance, Double balanceGoal, Double interestAmount, String notes){
		boolean rowAdded = true;
		try{
			
			PreparedStatement stmt = null;
			Connection conn = null;
			
			Class.forName("org.h2.Driver");
			
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/BudgetID", "decker233", "sammy");
			
			String sql = "INSERT INTO Account (Account_ID, User_ID, Account_Name, Account_Type_ID, Balance, Balance_Goal, Interest_Amount, Notes) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, accountID);
			stmt.setInt(2, userID);
			stmt.setString(3, accountName);
			stmt.setInt(4, accountTypeID);
			stmt.setDouble(5, balance);
			stmt.setDouble(6, balanceGoal);
			stmt.setDouble(7, interestAmount);
			stmt.setString(8, notes);
			
			stmt.executeUpdate();
			conn.close();
			
		}catch (Exception e){
			System.out.println("There was a problem adding data in AccountTypeDB: "+ e);
			rowAdded = false;
		}
		return rowAdded;
	}
}
