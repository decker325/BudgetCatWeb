package ORM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import Data.Transaction;

public class TransactionDB {
	public static boolean add(Transaction transaction){
		boolean rowAdded = true;
		try{
			
			PreparedStatement stmt = null;
			Connection conn = null;
			
			Class.forName("org.h2.Driver");
			
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/BudgetID", "decker233", "sammy");
			
			String sql = "INSERT INTO Transaction (Transaction_ID, Account_ID, Amount, Date_Of_Transaction, Category_ID, Location, Location_Name, Notes) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, transaction.transactionID);
			stmt.setInt(2, transaction.accountID);
			stmt.setDouble(3, transaction.amount);
			stmt.setDate(4, transaction.date);
			stmt.setInt(5, transaction.categoryID);
			stmt.setString(6, transaction.location);
			stmt.setString(7, transaction.locationName);
			stmt.setString(8, transaction.notes);
			
			stmt.executeUpdate();
			conn.close();
			
		}catch (Exception e){
			System.out.println("There was a problem adding data in transactionDB: "+ e);
			rowAdded = false;
		}
		return rowAdded;
	}
	
	public static boolean remove(Transaction transaction){
		boolean rowRemoved = true;
		try{
			
			PreparedStatement stmt = null;
			Connection conn = null;
			
			Class.forName("org.h2.Driver");
			
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/BudgetID", "decker233", "sammy");
			
			String sql = "DELETE FROM Transaction WHERE Transaction_ID= ?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, transaction.transactionID);
			
			stmt.executeUpdate();
			conn.close();
			
		}catch (Exception e){
			System.out.println("There was a problem removing data in transactionDB: "+ e);
			rowRemoved = false;
		}
		return rowRemoved;
	}
	
	public static boolean update(Transaction transaction){
		boolean rowUpdated = true;
		try{
			
			PreparedStatement stmt = null;
			Connection conn = null;
			
			Class.forName("org.h2.Driver");
			
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/BudgetID", "decker233", "sammy");
			
			String sql = "UPDATE Transaction SET Account_ID=?, Amount=?, Date_Of_Transaction=?, Category_ID=?, Location=?, Location_Name=?, Notes=? WHERE Transaction_ID=?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, transaction.accountID);
			stmt.setDouble(2, transaction.amount);
			stmt.setDate(3, transaction.date);
			stmt.setInt(4, transaction.categoryID);
			stmt.setString(5, transaction.location);
			stmt.setString(6, transaction.locationName);
			stmt.setString(7, transaction.notes);
			stmt.setInt(8, transaction.transactionID);
			
			stmt.executeUpdate();
			conn.close();
			
		}catch (Exception e){
			System.out.println("There was a problem updating data in transactionDB: "+ e);
			rowUpdated = false;
		}
		return rowUpdated;
	}
}
