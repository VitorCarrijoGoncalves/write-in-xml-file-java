package br.com.soap;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import br.com.soap.model.Person;

@SpringBootApplication
public class SpringBootWebApplication extends SpringBootServletInitializer {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootWebApplication.class, args);
		
		Person p1 = new Person();
		p1.setName("Julie");
		p1.setAge(8);
		
		Person p2 = new Person();
		p2.setName("Jonathan");
		p2.setAge(12);
		
		List<String> hobbies = new ArrayList<>();
		hobbies.add("play games");
		hobbies.add("play sports");
		
		List<Person> kids = new ArrayList<>();
		kids.add(p1);
		kids.add(p2);
		
		Person person = new Person();
		person.setAge(25);

		person.setHobbies(hobbies);
		person.setMarried(true);
		person.setName("John Klay");
		person.setKids(kids);
		
		personToXMLExample("person.xml", person);
		
//        Person person = XMLtoPersonExample("person.xml");
//        System.out.println(person);
	}
	
    private static Person XMLtoPersonExample(String filename) throws Exception {
        File file = new File(filename);
        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (Person) jaxbUnmarshaller.unmarshal(file);
    }
    
    private static void personToXMLExample(String filename, Person person) throws Exception {
        File file = new File(filename);
        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(person, file);
        jaxbMarshaller.marshal(person, System.out);
    }

}