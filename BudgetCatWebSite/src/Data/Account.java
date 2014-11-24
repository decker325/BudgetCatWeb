package Data;

import ORM.AccountDB;

public class Account {
public int accountID;
public int userID;
public String accountName;
public int accountTypeID;
public double balance;
public double balanceGoal;
public double interestAmount;
public String notes;

public Account(){
	
}

public boolean add(){
	return AccountDB.add(this);
}

public boolean remove(){
	return AccountDB.remove(this);
}

public boolean update(){
	return AccountDB.update(this);
}

}
