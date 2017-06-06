package com.opus.main;



import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import com.opus.pojo.Employee;
 
public class JaxbSchemaValidation {
 
    private static final String XML_FILE = "employee.xml";
 
    public static void main(String[] args) throws JAXBException, SAXException,
            IOException {
 
        JaxbSchemaValidation schemaValidation = new JaxbSchemaValidation();
        
        
        Employee em = new Employee();
        em.setId(2L);
        em.setAddress("Marol");
        em.setCity("Mumbai");
        em.setName("Ashu");
        em.setPincode(452001L);
        
 
 
        SchemaFactory sf = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(schemaValidation.getSchemaFile());
 
        // create JAXB contexte
        JAXBContext context = JAXBContext.newInstance(Employee.class);
 
        System.out.println("<!----------Generating the XML Output-------------->");
        // Instantiate marshaller via context
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.setSchema(schema);
 
        // Write to System.out
        m.marshal(em, System.out);
        m.marshal(em, new File(XML_FILE));
 
        System.out.println("<!---------------Generating the Java objects from XML Input-------------->");
        // Instantiate Unmarshaller via context
    
        Unmarshaller um = context.createUnmarshaller();
        Employee emp = (Employee) um.unmarshal(new FileReader(XML_FILE));

            System.out.println("Employee : " + emp);
    }
 
   private File getSchemaFile() {
        // Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File schemaFile = new File(classLoader.getResource("employee.xsd").getFile());
        return schemaFile;    } 
    
 
}
