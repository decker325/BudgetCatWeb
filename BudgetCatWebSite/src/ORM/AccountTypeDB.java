package ORM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class AccountTypeDB {
	public static boolean injectData(Map<String, String> map){
		boolean dataInjected = true;
		try{
			int accountTypeID = Integer.parseInt(map.get("Account_Type_ID"));
			String accountTypeName = map.get("Account_Type_Name");
			boolean asset = Boolean.valueOf(map.get("Budget_File_Name"));
			addAccountType(accountTypeID, accountTypeName, asset);
		}catch (Exception e){
			System.out.println("There was a problem injecting xml data in BudgetDB: "+ e);
			dataInjected = false;
		}
		return dataInjected;
	}
	
	public static boolean addAccountType(int accountTypeID, String accountTypeName, boolean asset){
		boolean rowAdded = true;
		try{
			
			PreparedStatement stmt = null;
			Connection conn = null;
			
			Class.forName("org.h2.Driver");
			
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/BudgetID", "decker233", "sammy");
			
			String sql = "INSERT INTO Account_Type (Account_Type_ID, Account_Type_Name, Asset) VALUES (?, ?, ?)";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, accountTypeID);
			stmt.setString(2, accountTypeName);
			stmt.setBoolean(3, asset);
			
			stmt.executeUpdate();
			conn.close();
			
		}catch (Exception e){
			System.out.println("There was a problem adding data in AccountTypeDB: "+ e);
			rowAdded = false;
		}
		return rowAdded;
	}
}
