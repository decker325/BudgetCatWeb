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
			stmt.execute("CREATE TABLE IF NOT EXISTS User(User_ID INT PRIMARY KEY AUTO_INCREMENT,User_Name VARCHAR(255) NOT NULL UNIQUE, Password VARCHAR(255) NOT NULL, Email VARCHAR(255) NOT NULL, Last_Log_In DATETIME)");
			stmt.execute("CREATE TABLE IF NOT EXISTS Account_Type(Account_Type_ID INT PRIMARY KEY AUTO_INCREMENT,Account_Type_Name VARCHAR(255) NOT NULL, Asset BOOLEAN NOT NULL)");
			stmt.execute("CREATE TABLE IF NOT EXISTS Account(Account_ID INT PRIMARY KEY AUTO_INCREMENT,User_ID INT NOT NULL, FOREIGN KEY (User_ID) REFERENCES User(User_ID), Account_Name VARCHAR(255), Account_Type_ID INT NOT NULL, FOREIGN KEY (Account_Type_ID) REFERENCES Account_Type(Account_Type_ID), Balance DOUBLE NOT NULL, BALANCE_GOAL DOUBLE, INTEREST_AMOUNT DOUBLE NOT NULL, Notes VARCHAR(255))");
			stmt.execute("CREATE TABLE IF NOT EXISTS Budget(Budget_ID INT PRIMARY KEY AUTO_INCREMENT, User_ID INT NOT NULL, FOREIGN KEY (User_ID) REFERENCES User(User_ID), Budget_Name VARCHAR(255) NOT NULL, Budget_Date DATE NOT NULL, Budget_File_Name VARCHAR(255) NOT NULL)");
			stmt.execute("CREATE TABLE IF NOT EXISTS Category(Category_ID INT PRIMARY KEY AUTO_INCREMENT,Category_Name VARCHAR(255) NOT NULL)");
			stmt.execute("CREATE TABLE IF NOT EXISTS Transaction(Transaction_ID INT PRIMARY KEY AUTO_INCREMENT, Account_ID INT NOT NULL, FOREIGN KEY (Account_ID) REFERENCES Account(ACCOUNT_ID) , Amount DOUBLE NOT NULL, Date_Of_Transaction DATE NOT NULL, Category_ID INT NOT NULL, FOREIGN KEY (Category_ID) REFERENCES Category(Category_ID), Location VARCHAR(255), Location_Name VARCHAR(255), Notes VARCHAR(255))");
			stmt.execute("CREATE TABLE IF NOT EXISTS User_Categories(Category_ID INT NOT NULL, FOREIGN KEY (Category_ID) REFERENCES Category(Category_ID), User_ID INT NOT NULL, FOREIGN KEY (User_ID) REFERENCES User(User_ID))");

			
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
