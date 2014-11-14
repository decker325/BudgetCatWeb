package ORM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class UserDB {
	public static boolean injectData(Map<String, String> map){
		boolean dataInjected = true;
		try{
			int userID = Integer.parseInt(map.get("User_ID"));
			Date date = new SimpleDateFormat("yyyy-dd-mm").parse(map.get("Last_Log_In"));
			String userName = map.get("User_Name");
			String password = map.get("Password");
			String email = map.get("Email");
			addUser(userID, userName, password, email, date);
		}catch (Exception e){
			System.out.println("There was a problem injecting xml data in BudgetDB: "+ e);
			dataInjected = false;
		}
		return dataInjected;
	}
	
	public static boolean addUser(int userID, String userName, String password, String email, Date lastLogIn){
		boolean rowAdded = true;
		try{
			
			PreparedStatement stmt = null;
			Connection conn = null;
			
			Class.forName("org.h2.Driver");
			
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/BudgetID", "decker233", "sammy");
			
			String sql = "INSERT INTO USER (User_ID, User_Name, Password, Email, Last_Log_In) VALUES (?, ?, ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userID);
			stmt.setString(2, userName);
			stmt.setString(3, password);
			stmt.setString(4, email);
			stmt.setDate(5, new java.sql.Date(lastLogIn.getTime()));
			
			stmt.executeUpdate();
			conn.close();
			
		}catch (Exception e){
			System.out.println("There was a problem adding data in BudgetDB: "+ e);
			rowAdded = false;
		}
		return rowAdded;
	}
}
