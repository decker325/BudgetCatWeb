package Data;

import java.sql.Date;

import ORM.BudgetDB;

public class Budget {
	public int budgetID;
	public String budgetName;
	public int userID;
	public Date date;
	public String budgetFileName;
	
	public Budget(){
		
	}
	
	public boolean add(){
		return BudgetDB.add(this);
	}
	
	public boolean remove(){
		return BudgetDB.remove(this);
	}
	
	public boolean update(){
		return BudgetDB.update(this);
	}
}
