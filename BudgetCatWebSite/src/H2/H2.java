package H2;
import java.sql.*;

public class H2 {

	public static void createTables(){
		try{
			Statement stmt = null;
			Connection conn = null;
			
			Class.forName("org.h2.Driver");
			
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/BudgetID", "decker233", "sammy");
			
			stmt = conn.createStatement();
			stmt.execute("");
			stmt.execute("");
			stmt.execute("");
			stmt.execute("");
			stmt.execute("");
			stmt.execute("");
			stmt.execute("");
			
			conn.close();
		}catch(Exception e)
		{
			System.out.println("There was an issue creatingTables: " + e);
		}
	}
	
	
	public static void deleteTables(){
		try{
			Statement stmt = null;
			Connection conn = null;
			
			Class.forName("org.h2.Driver");
			
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/BudgetID", "decker233", "sammy");
			
			String sql = "DROP TABLE IF EXISTS User, Account, Account_Type, Budget, Transaction, Category, User_Categories";
			
			stmt = conn.createStatement();
			
			stmt.execute(sql);
			
			conn.close();
		}catch(Exception e)
		{
			System.out.println("There was an issue deletingTables: " + e);
		}
	}
}
