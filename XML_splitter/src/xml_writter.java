import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
public class xml_writter {

	public void writter(int elementNumber) {
		
		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("PublishEmployeeDataRequest");
			doc.appendChild(rootElement);
			
			rootElement.setAttribute("xmlns", "http://www.mstart.hr/cardbroker");
			rootElement.setAttribute("xsi:schemaLocation", "http://www.mstart.hr/cardbroker  cardbroker.xsd");
			rootElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");

			// employee and person
			Element employee = doc.createElement("Employee");
			rootElement.appendChild(employee);

			Element person = doc.createElement("Person");
			rootElement.appendChild(person);
			
			
			// employee elements
			
			Element employeeId = doc.createElement("Id");
			employeeId.appendChild(doc.createTextNode(XML_splitter.EmployeeId));
			employee.appendChild(employeeId);
			
			Element localId = doc.createElement("LocalId");
			localId.appendChild(doc.createTextNode(XML_splitter.EmployeeLocalId));
			employee.appendChild(localId);
			
			Element status = doc.createElement("Status");
			status.appendChild(doc.createTextNode(XML_splitter.EmployeeStatus));
			employee.appendChild(status);
			
			// company elements
			Element company = doc.createElement("Company");
			employee.appendChild(company);
			
			Element companyId = doc.createElement("Id");
			companyId.appendChild(doc.createTextNode(XML_splitter.CompanyId));
			company.appendChild(companyId);
			
			Element companyName = doc.createElement("Name");
			companyName.appendChild(doc.createTextNode(XML_splitter.CompanyName));
			company.appendChild(companyName);
			
			
			// person elements
			Element firstName = doc.createElement("Firstname");
			firstName.appendChild(doc.createTextNode(XML_splitter.PersonFirstName));
			person.appendChild(firstName);
			
			Element lastName = doc.createElement("Lastname");
			lastName.appendChild(doc.createTextNode(XML_splitter.PersonLastName));
			person.appendChild(lastName);
			
			Element Oib = doc.createElement("Oib");
			Oib.appendChild(doc.createTextNode(XML_splitter.PersonOib));
			person.appendChild(Oib);
			
			Element dateOfBirth = doc.createElement("DateOfBirth");
			dateOfBirth.appendChild(doc.createTextNode(XML_splitter.PersonDateOfBirth));
			person.appendChild(dateOfBirth);
			
			Element gender = doc.createElement("Gender");
			gender.appendChild(doc.createTextNode(XML_splitter.PersonGender));
			person.appendChild(gender);
			
			Element address = doc.createElement("Address");
			person.appendChild(address);
			
			// adress elements
			
			Element street = doc.createElement("Street");
			street.appendChild(doc.createTextNode(XML_splitter.AddressStreet));
			address.appendChild(street);
			
			Element number = doc.createElement("Number");
			number.appendChild(doc.createTextNode(XML_splitter.AddressNumber));
			address.appendChild(number);
			
			Element zip = doc.createElement("Zip");
			zip.appendChild(doc.createTextNode(XML_splitter.AddressZip));
			address.appendChild(zip);
			/*
			Element municipality = doc.createElement("Municipality");
			municipality.appendChild(doc.createTextNode(XML_splitter.AddressMunicipality));
			address.appendChild(municipality);
			*/
			Element city = doc.createElement("City");
			city.appendChild(doc.createTextNode(XML_splitter.AddressCity));
			address.appendChild(city);
						
			// write the content into xml file
			// ovu for petlju prebaciti u glavnu klasu
			//for (int i = 0; i<=6; i++){
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File("C:\\Users\\isosic\\Documents\\JavaDev\\XML_splitter\\file" + elementNumber + ".xml"));
			

			transformer.transform(source, result);

			System.out.println("File saved!");
			//}
		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }
		}
	}

