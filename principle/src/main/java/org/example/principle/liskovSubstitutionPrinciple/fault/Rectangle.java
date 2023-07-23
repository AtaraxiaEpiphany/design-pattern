package org.example.principle.liskovSubstitutionPrinciple.fault;

/**
 * @Title: Rectangle 长方形
 * @Author Hannibal
 * @Package org.example.principle.LiskovSubstitutionPrinciple
 * @Date 23/07/2023 11:25
 * @description: TODO
 */
public class Rectangle {
    private double length;
    private double width;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
