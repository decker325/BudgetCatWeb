package Part3Demo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import H2.H2;
import ValidationAndParsing.BCatDOMParsing;
import ValidationAndParsing.ValidateXSD;
import ValidationAndParsing.XMLDataInjection;

public class Part3Demo {
	public static void main(String[] args){
	// clear tables for empty h2 database for demonstration
    H2.deleteTables();
	
    
	// Add tables to the database if they don't already exist
	H2.createTables();
	
	Boolean validXML = false;
	List<String> files = new ArrayList<String>(Arrays.asList(new String[] {"XML/Users.xml","XML/Budgets.xml", "XML/AccountType.xml", "XML/Account.xml"}));
	for(int i = 0; i < files.size(); i++){
	
	//validate xml against schema before parsing and adding data to database
	validXML = ValidateXSD.validateXMLAgainstSchema(files.get(i));
	//get the parsed data for the xml file if the schema validated
	if(validXML){
		List<HashMap<String,String>> maps = BCatDOMParsing.getParsedData(files.get(i));
		XMLDataInjection.injectData(maps);
	}
	}
	
	}
}
