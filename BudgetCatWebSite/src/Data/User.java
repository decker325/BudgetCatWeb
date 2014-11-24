package Data;

import java.sql.Date;

import ORM.UserDB;

public class User {

	public int userID;
	public String userName;
	public String email;
	public String password;
	public Date date;
	
	public User(){
		
	}
	
	public boolean add(){
		return UserDB.add(this);
	}
	
	public boolean remove(){
		return UserDB.remove(this);
	}
	
	public boolean update(){
		return UserDB.update(this);
	}
}
