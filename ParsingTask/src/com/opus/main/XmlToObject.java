package com.opus.main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.opus.pojo.Employee;

public class XmlToObject {

	
    public static void main(String[] args) {  
    	   
        try {  
      
           File file = new File("employee.xml");  
           JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);  
      
           Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
           Employee emp= (Employee) jaxbUnmarshaller.unmarshal(file);  
           
           System.out.println(emp.getId() + "  " +  emp.getName() +""+  emp.getAddress() +""+ emp.getCity() +""+ emp.getPincode()  );
           
        } catch (JAXBException e) {  
            e.printStackTrace();  
          }  
	
        
    }
}
