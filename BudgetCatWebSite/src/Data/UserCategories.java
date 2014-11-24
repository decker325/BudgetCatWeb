package Data;

import ORM.UserCategoriesDB;

public class UserCategories {

	public int CategoryID;
	public int UserID;
	
	public UserCategories(){
		
	}
	
	public boolean add(){
		return UserCategoriesDB.add(this);
	}
	
	public boolean remove(){
		return UserCategoriesDB.remove(this);
	}
	
}
