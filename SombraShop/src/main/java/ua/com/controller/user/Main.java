package ua.com.controller.user;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.com.Service.CategoryService;
import ua.com.ServiceImpl.CategoryServiceImpl;

public class Main {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/applicationContext.xml"); 
		CategoryService  categoryService= context.getBean(CategoryServiceImpl.class);
		categoryService.delete(1);
	}
}
