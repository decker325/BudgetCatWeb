package ORM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import Data.UserCategories;

public class UserCategoriesDB {

	public static boolean add(UserCategories userCategories){
		boolean rowAdded = true;
		try{
			
			PreparedStatement stmt = null;
			Connection conn = null;
			
			Class.forName("org.h2.Driver");
			
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/BudgetID", "decker233", "sammy");
			
			String sql = "INSERT INTO User_Categories (Category_ID, User_ID) VALUES (?, ?)";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userCategories.CategoryID);
			stmt.setInt(2, userCategories.UserID);
			
			stmt.executeUpdate();
			conn.close();
			
		}catch (Exception e){
			System.out.println("There was a problem adding data in userCategoryDB: "+ e);
			rowAdded = false;
		}
		return rowAdded;
	}
	
	public static boolean remove(UserCategories userCategories){
		boolean rowRemoved = true;
		try{
			
			PreparedStatement stmt = null;
			Connection conn = null;
			
			Class.forName("org.h2.Driver");
			
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/BudgetID", "decker233", "sammy");
			
			String sql = "DELETE FROM User_Categories WHERE Category_ID=?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userCategories.CategoryID);
			
			stmt.executeUpdate();
			conn.close();
			
		}catch (Exception e){
			System.out.println("There was a problem removing data in userCategoryDB: "+ e);
			rowRemoved = false;
		}
		return rowRemoved;
	}

}
