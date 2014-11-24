package ORM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import Data.Budget;

public class BudgetDB {
	
	public static boolean add(Budget budget){
		boolean rowAdded = true;
		try{
			
			PreparedStatement stmt = null;
			Connection conn = null;
			
			Class.forName("org.h2.Driver");
			
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/BudgetID", "decker233", "sammy");
			
			String sql = "INSERT INTO BUDGET (Budget_ID, BUDGET_NAME, USER_ID, BUDGET_DATE, BUDGET_FILE_NAME) VALUES (?, ?, ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, budget.budgetID);
			stmt.setString(2, budget.budgetName);
			stmt.setInt(3, budget.userID);
			stmt.setDate(4, budget.date);
			stmt.setString(5, budget.budgetName);
			
			stmt.executeUpdate();
			conn.close();
			
		}catch (Exception e){
			System.out.println("There was a problem adding data in BudgetDB: "+ e);
			rowAdded = false;
		}
		return rowAdded;
	}
	
	public static boolean remove(Budget budget){
		boolean rowRemoved = true;
		try{
			
			PreparedStatement stmt = null;
			Connection conn = null;
			
			Class.forName("org.h2.Driver");
			
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/BudgetID", "decker233", "sammy");
			
			String sql = "DELETE FROM BUDGET WHERE Budget_ID=?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, budget.budgetID);
			
			stmt.executeUpdate();
			conn.close();
			
		}catch (Exception e){
			System.out.println("There was a problem removing data in BudgetDB: "+ e);
			rowRemoved = false;
		}
		return rowRemoved;
	}
	
	public static boolean update(Budget budget){
		boolean rowUpdated = true;
		try{
			
			PreparedStatement stmt = null;
			Connection conn = null;
			
			Class.forName("org.h2.Driver");
			
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/BudgetID", "decker233", "sammy");
			
			String sql = "UPDATE BUDGET SET BUDGET_NAME=?, USER_ID=?, BUDGET_DATE=?, BUDGET_FILE_NAME=? WHERE Budget_ID=?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, budget.budgetName);
			stmt.setInt(2, budget.userID);
			stmt.setDate(3, budget.date);
			stmt.setString(4, budget.budgetName);
			stmt.setInt(5, budget.budgetID);
			
			stmt.executeUpdate();
			conn.close();
			
		}catch (Exception e){
			System.out.println("There was a problem updating data in BudgetDB: "+ e);
			rowUpdated = false;
		}
		return rowUpdated;
	}
}
