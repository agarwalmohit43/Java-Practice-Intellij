package com.mohit.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Circle implements Shape, ApplicationEventPublisherAware {

    private Point pointA;

    private ApplicationEventPublisher publisher;

    @Autowired
    private MessageSource messageSource;

    public MessageSource getMessageSource() {
        return messageSource;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public Point getPointA() {
        return pointA;
    }

//    @Required
    @Autowired
    @Qualifier("circleBean")
    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    @Override
    public void draw() {
        System.out.println(this.messageSource.getMessage("drawing.circle", null, "Default Drawing", null));
        System.out.println(this.messageSource.getMessage("drawing.point",new Object[]{pointA.getWidth(),pointA.getHeight()}, "Default Drawing Points (0,0)", null));
//        System.out.println("Cordinates ( "+pointA.getWidth()+" "+pointA.getHeight()+" )");

        DrawEvent drawEvent =  new DrawEvent(this);
        publisher.publishEvent(drawEvent);
    }

    @PostConstruct
    public void initialisationCircle(){
        System.out.println("Initialising Circle");
    }

    @PreDestroy
    public void destroyCircle(){
        System.out.println("Destroying Circle");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
