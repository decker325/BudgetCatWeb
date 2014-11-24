package ORM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import Data.Category;

public class CategoryDB {
	public static boolean add(Category category){
		boolean rowAdded = true;
		try{
			
			PreparedStatement stmt = null;
			Connection conn = null;
			
			Class.forName("org.h2.Driver");
			
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/BudgetID", "decker233", "sammy");
			
			String sql = "INSERT INTO CATEGORY (Category_ID, Category_Name) VALUES (?, ?)";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, category.categoryID);
			stmt.setString(2, category.categoryName);
			
			stmt.executeUpdate();
			conn.close();
			
		}catch (Exception e){
			System.out.println("There was a problem adding data in categoryDB: "+ e);
			rowAdded = false;
		}
		return rowAdded;
	}
	
	public static boolean remove(Category category){
		boolean rowRemoved = true;
		try{
			
			PreparedStatement stmt = null;
			Connection conn = null;
			
			Class.forName("org.h2.Driver");
			
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/BudgetID", "decker233", "sammy");
			
			String sql = "DELETE FROM CATEGORY WHERE Category_ID=?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, category.categoryID);
			
			stmt.executeUpdate();
			conn.close();
			
		}catch (Exception e){
			System.out.println("There was a problem removing data in categoryDB: "+ e);
			rowRemoved = false;
		}
		return rowRemoved;
	}
	
	public static boolean update(Category category){
		boolean rowUpdated = true;
		try{
			
			PreparedStatement stmt = null;
			Connection conn = null;
			
			Class.forName("org.h2.Driver");
			
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/BudgetID", "decker233", "sammy");
			
			String sql = "UPDATE CATEGORY SET Category_Name=? WHERE Category_ID=?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, category.categoryName);
			stmt.setInt(2, category.categoryID);
			
			stmt.executeUpdate();
			conn.close();
			
		}catch (Exception e){
			System.out.println("There was a problem updating data in categoryDB: "+ e);
			rowUpdated = false;
		}
		return rowUpdated;
	}
}
