package Data;

import java.sql.Date;

import ORM.TransactionDB;

public class Transaction {
	public int transactionID;
	public int accountID;
	public double amount;
	public Date date;
	public int categoryID;
	public String location;
	public String locationName;
	public String notes;
	
	public Transaction(){
		
	}
	
	public boolean add(){
		return TransactionDB.add(this);
	}
	
	public boolean remove(){
		return TransactionDB.remove(this);
	}
	
	public boolean update(){
		return TransactionDB.update(this);
	}
}
