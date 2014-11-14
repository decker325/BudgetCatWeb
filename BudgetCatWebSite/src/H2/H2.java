package H2;
import java.sql.*;

public class H2 {

	public static void createTables(){
		try{
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/BudgetID", "sa", "");
			
			conn.close();
		}catch(Exception e)
		{
			System.out.println("There was an issue creatingTables" + e.getMessage());
		}
	}
	public static void deleteTables(){
		try{
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/BudgetID", "sa", "");
			
			conn.close();
		}catch(Exception e)
		{
			System.out.println("There was an issue deletingTables" + e.getMessage());
		}
	}
}
