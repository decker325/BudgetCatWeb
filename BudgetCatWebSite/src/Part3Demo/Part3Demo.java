package Part3Demo;
import H2.H2;
import ValidationAndParsing.validateXSD;

public class Part3Demo {
	public static void main(String[] args){
	// clear tables for empty h2 database for demonstration
    H2.deleteTables();
	
	// Add tables to the database if they don't already exist
	H2.createTables();
	
	//validate xml against schema before parsing and adding data to database
	validateXSD.validateXMLAgainstSchema("XML/Budgets.xml");
	}
}
