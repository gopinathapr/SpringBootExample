package com.prg.springboot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prg.springboot.dto.Employee;

@RestController
public class TestController {

	@RequestMapping("/hello/{name}")
	String hello(@PathVariable String name) {
		return "Hello, " + name + "! Welcome to Spring boot!!";
	}

	@RequestMapping(path = "/addEmp", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.TEXT_HTML_VALUE)
	public @ResponseBody
	String saveEmployee(@RequestBody Employee emp) {
		try {
			System.out.println(emp.toString());
			String path = "C:\\Users\\611777858\\workspace\\SpringBoot\\Store\\";
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path + emp.getName() + ".txt"));
			out.writeObject(emp);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Save Successful";
	}

	@RequestMapping(path = "/findEmp", method = RequestMethod.POST, consumes = MediaType.TEXT_HTML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody
	Employee findEMP(@RequestBody String name) throws XMLStreamException {
		System.out.println("XML-->" + name);

		Employee emp = new Employee();
		String path = "C:\\Users\\611777858\\workspace\\SpringBoot\\Store\\";

		try {
			/*
			 * JAXBContext jaxbContext; jaxbContext =
			 * JAXBContext.newInstance(Employee.class); Unmarshaller unmarshal =
			 * jaxbContext.createUnmarshaller(); XMLStreamReader reader =
			 * XMLInputFactory.newInstance().createXMLStreamReader(new
			 * StringReader(xml)); emp = (Employee) unmarshal.unmarshal(reader);
			 */

			ObjectInputStream out = new ObjectInputStream(new FileInputStream(path + name + ".txt"));
			emp = (Employee) out.readObject();

		} catch (FactoryConfigurationError e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return emp;
	}
}
