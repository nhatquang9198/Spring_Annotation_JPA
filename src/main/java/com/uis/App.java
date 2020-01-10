package com.uis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.AppConfig;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//		PersonService personService = (PersonService) context.getBean("personService");
//		InfoService infoService = (InfoService) context.getBean("infoService");
//
//		Person person = new Person("Nhat Quang");
//		person.setName("test");
//		// person.setId(3);
//
//		List<Info> listInfo = new ArrayList<Info>();
//		Info info1 = new Info();
//		info1.setPerson(person);
//		Info info2 = new Info();
//		info1.setPerson(person);
//		listInfo.add(info1);
//		listInfo.add(info2);
//
//		person.setInfo(listInfo);
//
//		personService.create(person);
//		infoService.createMany(listInfo);
//
//		List<Person> list = personService.readAll();
//		list.forEach(p -> System.out.println(p));
//		System.out.println("-----------------------------------------------------");
//		System.out.println(list.get(0));
////		personService.delete(list.get(0));
//		System.out.println("-----------------------------------------------------");
//		list = personService.readAll();
//		list.forEach(p -> System.out.println(p));
//
//		((AbstractApplicationContext) context).close();

	}
}
