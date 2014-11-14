package ORM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class BudgetDB {
	
	public static boolean injectData(Map<String, String> map){
		boolean dataInjected = true;
		try{
			String budgetName = map.get("Budget_Name");
			int userID = Integer.parseInt(map.get("User_ID"));
			Date date = new SimpleDateFormat("yyyy-dd-mm").parse(map.get("Budget_Date"));
			String budgetFileName = map.get("Budget_File_Name");
			addBudget(budgetName, userID, date, budgetFileName);
		}catch (Exception e){
			System.out.println("There was a problem injecting xml data in BudgetDB: "+ e);
			dataInjected = false;
		}
		return dataInjected;
	}
	
	public static boolean addBudget(String budgetName, int userID, Date date, String budgetFileName){
		boolean rowAdded = true;
		try{
			
			PreparedStatement stmt = null;
			Connection conn = null;
			
			Class.forName("org.h2.Driver");
			
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/BudgetID", "decker233", "sammy");
			
			String sql = "INSERT INTO BUDGET (BUDGET_NAME, USER_ID, BUDGET_DATE, BUDGET_FILE_NAME) VALUES (?, ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, budgetName);
			stmt.setInt(2, userID);
			stmt.setDate(3, new java.sql.Date(date.getTime()));
			stmt.setString(4, budgetName);
			
			stmt.executeUpdate();
			conn.close();
			
		}catch (Exception e){
			System.out.println("There was a problem adding data in BudgetDB: "+ e);
			rowAdded = false;
		}
		return rowAdded;
	}
}
