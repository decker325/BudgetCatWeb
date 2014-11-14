package Part3Demo;
import java.util.Map;

import H2.H2;
import ValidationAndParsing.BCatDOMParsing;
import ValidationAndParsing.validateXSD;

public class Part3Demo {
	public static void main(String[] args){
	// clear tables for empty h2 database for demonstration
    H2.deleteTables();
	
	// Add tables to the database if they don't already exist
	H2.createTables();
	
	Boolean validXML = false;
	//validate xml against schema before parsing and adding data to database
	validXML = validateXSD.validateXMLAgainstSchema("XML/Budgets.xml");
	//get the parsed data for the xml file if the schema validated
	if(validXML){
		Map<String, String> map = BCatDOMParsing.getParsedData("XML/Budgets.xml");
	}
	}
}
