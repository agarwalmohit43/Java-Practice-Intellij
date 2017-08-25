package com.mohit.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationContextEvent;

public class DrawEvent extends ApplicationEvent {
    public DrawEvent(Object source) {
        super(source);
    }

    @Override
    public String toString() {
        return "Drawing event occured";
    }
}
