package ValidationAndParsing;
import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

	 
	import org.xml.sax.SAXException;
	 
public class ValidateXSD {
	
	private String BudgetCatXDS = "SchemaAndDTD/BudgetCat2.xsd";
	
	private ValidateXSD(){
		
	}
	
	public ValidateXSD(String xsdFile){
		BudgetCatXDS = xsdFile;
	}
	    public boolean validateXMLAgainstSchema(String file) {
	      	
	        boolean valid = false;
	        valid = validateXMLSchema(file);
	        if(!valid){
	        	System.out.println(file + " validates against " + BudgetCatXDS + " ? " + valid);
	        }
	        
	        return valid;
	      }
	     
	    private boolean validateXMLSchema(String xmlPath){
	         boolean valid = true;
	        try {
	        	
	            SchemaFactory factory = 
	                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	            Schema schema = factory.newSchema(new File(BudgetCatXDS));
	            Validator validator = schema.newValidator();
	            validator.validate(new StreamSource(new File(xmlPath)));
	        } catch (IOException|SAXException e) {
	            System.out.println("Exception: "+ e.getMessage());
	            valid =  false;
	        }
	        return valid;
	    
	}

}
