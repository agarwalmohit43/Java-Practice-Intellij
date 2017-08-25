package com.mohit.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

    public static void main(String[] args) {
        /*BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		Triangle triangle = (Triangle) factory.getBean("triangle");
		triangle.draw();*/

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        context.registerShutdownHook();
        Triangle triangle = (Triangle) context.getBean("triangle");
        triangle.draw();
    }

}
