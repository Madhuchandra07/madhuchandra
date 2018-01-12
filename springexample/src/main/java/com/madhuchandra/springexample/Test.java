package com.madhuchandra.springexample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext con=new ClassPathXmlApplicationContext();
		ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
	   A ap=(A) context.getBean("a");
	   
	   ap.display();
		//ApplicationContext context=null;
		
//ClassPathXmlApplicationContext con=new ClassPathXmlApplicationContext();

//.getResource("ApplicationContext.xml");
//ApplicationContext context1=(ApplicationContext)con.getResource("ApplicationContext.xml");
con.close();

	}

}
