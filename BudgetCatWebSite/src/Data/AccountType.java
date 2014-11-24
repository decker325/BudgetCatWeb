package Data;

import ORM.AccountTypeDB;

public class AccountType {

	public int accountTypeID;
	public String accountTypeName;
	public boolean asset;
	
	public AccountType(){
		
	}
	
	public boolean add(){
		return AccountTypeDB.add(this);
	}
	
	public boolean remove(){
		return AccountTypeDB.remove(this);
	}
	
	public boolean update(){
		return AccountTypeDB.update(this);
	}
}
