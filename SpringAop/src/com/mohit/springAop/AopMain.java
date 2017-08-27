package com.mohit.springAop;

import com.mohit.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {

    public static void main(String[] args){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
        ShapeService obj= context.getBean("shape", ShapeService.class);
        System.out.println(obj.getCircle().getName());
    }
}
