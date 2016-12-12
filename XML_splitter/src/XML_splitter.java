import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XML_splitter {
	
	public static String EmployeeId;
	public static String EmployeeLocalId;
	public static String EmployeeStatus;
	
	public static String CompanyId;
	public static String CompanyName;
	
	public static String PersonFirstName;
	public static String PersonLastName;
	public static String PersonOib;
	public static String PersonDateOfBirth;
	public static String PersonGender;
	
	public static String AddressStreet;
	public static String AddressNumber;
	public static String AddressZip;
	public static String AddressCity;
	public static String AddressMunicipality;

	public static void main(String argv[]) {

		
	xml_writter writer = new xml_writter();
	
	
		 try {	
			 File inputFile = null;
	         inputFile = new File("eKolektor_inactive_export.xml");
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
	         
	         
	         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	         NodeList nList = doc.getElementsByTagName("X");
	         System.out.println("----------------------------");
	         
	         
	         for (int temp = 0; temp < nList.getLength(); temp++) {
	            Node nNode = nList.item(temp);
	            System.out.println("\nCurrent Element :"+ nNode.getNodeName());
	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	               Element eElement = (Element) nNode;
	               System.out.println(temp + "\n");
	               
	             
					EmployeeId = eElement.getElementsByTagName("Id").item(0).getTextContent();
					System.out.println(EmployeeId);
					EmployeeLocalId = eElement.getElementsByTagName("LocalId").item(0).getTextContent();
					System.out.println(EmployeeLocalId);
					EmployeeStatus = eElement.getElementsByTagName("Status").item(0).getTextContent();
					System.out.println(EmployeeStatus);
					   
					   CompanyId = eElement.getElementsByTagName("Company").item(0).getChildNodes().item(1).getTextContent();
					   System.out.println(CompanyId);
					   CompanyName = eElement.getElementsByTagName("Name").item(0).getTextContent();
					   System.out.println(CompanyName);
					   
					   PersonFirstName = eElement.getElementsByTagName("Firstname").item(0).getTextContent();
					   System.out.println(PersonFirstName);
					   PersonLastName = eElement.getElementsByTagName("Lastname").item(0).getTextContent();
					   System.out.println(PersonLastName);
					   PersonOib = eElement.getElementsByTagName("Oib").item(0).getTextContent();
					   System.out.println(PersonOib);
					   PersonDateOfBirth = eElement.getElementsByTagName("DateOfBirth").item(0).getTextContent();
					   System.out.println(PersonDateOfBirth);
					   PersonGender = eElement.getElementsByTagName("Gender").item(0).getTextContent();
					   System.out.println(PersonGender);
					   

					   AddressStreet = eElement.getElementsByTagName("Street").item(0).getTextContent();
					   System.out.println(AddressStreet);
				try {
					   AddressNumber = eElement.getElementsByTagName("Number").item(0).getTextContent();
					   System.out.println(AddressNumber);
	            } catch (NullPointerException e) {
						System.out.println("-----Defektni unos!-----");
						e.printStackTrace();
				}
				 
					   AddressZip = eElement.getElementsByTagName("Zip").item(0).getTextContent();
					   System.out.println(AddressZip);
					/*   AddressMunicipality = eElement.getElementsByTagName("Municipality").item(0).getTextContent();
					   System.out.println(AddressMunicipality);*/
					   AddressCity = eElement.getElementsByTagName("City").item(0).getTextContent();
					   System.out.println(AddressCity);
					   

	               
	               writer.writter(temp);
	              
	               /*
	               System.out.println("Student roll no : " + eElement.getAttribute("rollno"));
	               System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
	               System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
	               System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
	               System.out.println("Marks : " + eElement.getElementsByTagName("marks").item(0).getTextContent());
	               */
	            }
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}
}
