package ORM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import Data.User;

public class UserDB {
	public static boolean add(User user){
		boolean rowAdded = true;
		try{
			
			PreparedStatement stmt = null;
			Connection conn = null;
			
			Class.forName("org.h2.Driver");
			
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/BudgetID", "decker233", "sammy");
			
			String sql = "INSERT INTO USER (User_ID, User_Name, Password, Email, Last_Log_In) VALUES (?, ?, ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, user.userID);
			stmt.setString(2, user.userName);
			stmt.setString(3, user.password);
			stmt.setString(4, user.email);
			stmt.setDate(5, user.date);
			
			stmt.executeUpdate();
			conn.close();
			
		}catch (Exception e){
			System.out.println("There was a problem adding data in userDB: "+ e);
			rowAdded = false;
		}
		return rowAdded;
	}
	
	public static boolean remove(User user){
		boolean rowRemoved = true;
		try{
			
			PreparedStatement stmt = null;
			Connection conn = null;
			
			Class.forName("org.h2.Driver");
			
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/BudgetID", "decker233", "sammy");
			
			String sql = "DELETE FROM USER WHERE User_ID = ?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, user.userID);
			
			stmt.executeUpdate();
			conn.close();
			
		}catch (Exception e){
			System.out.println("There was a problem removing data in userDB: "+ e);
			rowRemoved = false;
		}
		return rowRemoved;
	}
	
	public static boolean update(User user){
		boolean rowUpdated = true;
		try{
			
			PreparedStatement stmt = null;
			Connection conn = null;
			
			Class.forName("org.h2.Driver");
			
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/BudgetID", "decker233", "sammy");
			//User_ID, User_Name, Password, Email, Last_Log_In
			String sql = "UPDATE USER SET User_Name=?,Password=?,Email=?,Last_Log_In=? WHERE User_ID=?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.userName);
			stmt.setString(2, user.password);
			stmt.setString(3, user.email);
			stmt.setDate(4, user.date);
			stmt.setInt(5, user.userID);
			
			stmt.executeUpdate();
			conn.close();
			
		}catch (Exception e){
			System.out.println("There was a problem updating data in userDB: "+ e);
			rowUpdated = false;
		}
		return rowUpdated;
	}
}
