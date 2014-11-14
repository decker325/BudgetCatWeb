package ValidationAndParsing;
import java.util.*;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.Attr;
import org.w3c.dom.NodeList;

import javax.xml.parsers.*;

	public class BCatDOMParsing {

		/**
		 * @param args
		 * @throws Exception 
		 */
		public static List<HashMap<String,String>> getParsedData(String file) {
			List<HashMap<String,String>> maps = new ArrayList<HashMap<String,String>>();
			HashMap<String, String> map = new HashMap<String, String>();
			
			try{	
				
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			
			factory.setValidating(true);
			
			factory.setNamespaceAware(true);
		
				Document theDocument = FileRootDocumentGet(file);
			
			
			Node documentNode = DocumentNodeGet(theDocument);
			
				String nodeName = documentNode.getNodeName();
				
			   	System.out.println("Document node name = " + nodeName);
				NodeList ElementArray = documentNode.getChildNodes();
				for(int i = 0; i < ElementArray.getLength(); i++){
						NodeList CATEGORYELEMENTS = ElementArray.item(i).getChildNodes();
						map = new HashMap<String, String>();
						
						for(int j=0; j < CATEGORYELEMENTS.getLength(); j++)
						{
							Node currentNode = CATEGORYELEMENTS.item(j);
							if(!currentNode.getNodeName().equalsIgnoreCase("#text"))
							{
								String columnName = currentNode.getNodeName();
								String columnValue = currentNode.getTextContent();
								map.put(columnName, columnValue);
								System.out.println(columnName + " = " + columnValue);
							}
						}
						if(map.size() > 0){
						map.put("Node_Name", nodeName);
						maps.add(map);
						}
						System.out.println();
					}
				
				System.out.println("Parsing complete");
			
			} catch (Exception E){
				System.out.println("Error in parsing: " + E.getMessage());
			}
			
			return maps;
		}
		
	    public static Document FileRootDocumentGet(String FileName) 
	    	      throws Exception{
	    		Document TheDocument=null;
	    		DocumentBuilderFactory factory =
	    				    DocumentBuilderFactory.newInstance();
	    		DocumentBuilder parser = factory.newDocumentBuilder();
	    		TheDocument = parser.parse(FileName);
	    		return(TheDocument);
	    }
	    
	    public static Node DocumentNodeGet(Document TheDocument){
	    	Node theNode=null;
	    	theNode = TheDocument.getDocumentElement();
	    	return(theNode);
	    }
	    
	    public static Node[] NodeElementSelectManyGivenName(Node TheNode,
	    		String TheName){
	    	int count = 0;
	    	Node[] SelectedNodes=null;

	    	NodeList children = TheNode.getChildNodes();

	    	if (children != null) {
	    		int len = children.getLength();
	    		for (int i = 0; i < len; i++) {
	    			short nodeType=children.item(i).getNodeType();
	    			Node oneChild=children.item(i);
	    			if (nodeType == Node.ELEMENT_NODE){
	    				String nodeName = oneChild.getNodeName();
	    				if(nodeName.equals(TheName)){
	    					count++;
	    				}
	    			}
	    		}

	    		SelectedNodes = new Node[count];
	    		count = 0;
	    		for (int i = 0; i < len; i++) {
	    			short nodeType=children.item(i).getNodeType();
	    			Node oneChild=children.item(i);
	    			if (nodeType == Node.ELEMENT_NODE){
	    				String nodeName = oneChild.getNodeName();
	    				if(nodeName.equals(TheName)){
	    					SelectedNodes[count] = oneChild; count++;
	    				}
	    			}
	    		}

	    	}

	    	return(SelectedNodes);
	    }

	    public static String NodeAttributeValueGet(Node TheNode, 
	    		String AttributeName){
	    	String theValue = null;
	    	NamedNodeMap attrs = TheNode.getAttributes();
	    	Attr nameAttribute = (Attr)attrs.getNamedItem(AttributeName);
	    	if(nameAttribute != null) theValue = nameAttribute.getValue();
	    	return theValue;
	    }

	    public static Node[] NodeSelectManyGivenAttributeValue(Node[] Nodes, 
	    		String AttributeName, 
	    		String Value){
	    	Node[] selectedNodes = null;
	    	ArrayList<Node> selectedNodesList = new ArrayList<Node>();

	    	int len = Nodes.length;
	    	for(int i = 0; i < len; i++){
	    		String AttributeValue = NodeAttributeValueGet(Nodes[i],
	    				AttributeName);
	    		if(AttributeValue.equals(Value)){
	    			selectedNodesList.add(Nodes[i]);
	    		}
	    	}
	    	selectedNodes = new Node[len = selectedNodesList.size()];

	    	for(int i = 0; i < len; i++){
	    		selectedNodes[i] = (Node)selectedNodesList.get(i);
	    	}

	    	return selectedNodes;
	    }

}
