package com.douzone.container.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.douzone.container.user.User1;

public class TestContainer {

	public static void main(String[] args) {
//		testBeanFactory01();
//		testBeanFactory02();
		testApplicationContext01();
		testApplicationContext02();
		

	}
	
	
	
	//XML Auto-Configuration(Annotation Scanning)
		public static void testApplicationContext01() {
			ApplicationContext appContext 
			= new ClassPathXmlApplicationContext("config/user/applicationContext01.xml");
			
			User1 user1 = appContext.getBean(User1.class);
			System.out.println(user1.getName());
			
			// Bean의 id가 자동으로 설정됨
			user1 = (User1) appContext.getBean("user1");
			System.out.println(user1.getName());
		}
		
		//XML Bean Configuration(implicit Configuration)
		public static void testApplicationContext02() {
			ApplicationContext appContext 
			= new ClassPathXmlApplicationContext("config/user/applicationContext02.xml");
			
			User1 user1 = appContext.getBean(User1.class);
			System.out.println(user1.getName());
			
			// Bean 설정에서는 Bean의 id가 자동으로 설정이 안됨
			// 명시적으로 applicationContext02에 설정해야한다.
			user1 = (User1) appContext.getBean("user1");
			System.out.println(user1.getName());
		}
	
	
	
	
	
	
	//XML Auto-Configuration(Annotation Scanning)
	public static void testBeanFactory01() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("config/user/applicationContext01.xml"));
		
		User1 user1 = bf.getBean(User1.class);
		System.out.println(user1.getName());
		
		// Bean의 id가 자동으로 설정됨
		user1 = (User1) bf.getBean("user1");
		System.out.println(user1.getName());
	}
	
	//XML Bean Configuration(implicit Configuration)
	public static void testBeanFactory02() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("config/user/applicationContext02.xml"));
		
		User1 user1 = bf.getBean(User1.class);
		System.out.println(user1.getName());
		
		// Bean 설정에서는 Bean의 id가 자동으로 설정이 안됨
		// 명시적으로 applicationContext02에 설정해야한다.
		user1 = (User1) bf.getBean("user1");
		System.out.println(user1.getName());
	}

}
