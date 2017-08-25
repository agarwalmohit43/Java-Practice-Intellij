package com.mohit.spring;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

public class Triangle implements InitializingBean,BeanNameAware,DisposableBean {

    //to call init and destroy method we can do without implementing by setting in srring.xml ex: default-init-method="methodName" and vice versa

    private Point pointA, pointB, pointC;

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    public void draw(){
        System.out.println("Point A -> Width: "+getPointA().getWidth()+" Height: "+getPointA().getHeight());
        System.out.println("Point B -> Width: "+getPointB().getWidth()+" Height: "+getPointB().getHeight());
        System.out.println("Point C -> Width: "+getPointC().getWidth()+" Height: "+getPointC().getHeight());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean Started Init method called");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("Bean -> "+s);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean destroyed destroyed() called");
    }
}
