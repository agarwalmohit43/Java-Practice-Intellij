package com.mohit.spring;

import sun.security.provider.SHA;

public class Triangle implements Shape {

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

    @Override
    public void draw() {
        System.out.println("Point A ( Width: "+getPointA().getWidth()+" Height: "+getPointA().getHeight()+" )");
        System.out.println("Point B ( Width: "+getPointB().getWidth()+" Height: "+getPointB().getHeight()+" )");
        System.out.println("Point C ( Width: "+getPointC().getWidth()+" Height: "+getPointC().getHeight()+" )");
    }
}
