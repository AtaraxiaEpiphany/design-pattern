package org.example.principle.liskovSubstitutionPrinciple.correct;

/**
 * @Title: Rectangle
 * @Author Hannibal
 * @Package org.example.principle.LiskovSubstitutionPrinciple.correct
 * @Date 23/07/2023 11:52
 * @description: TODO
 */
public class Rectangle implements Quadrangle {
    private double length;

    private double width;

    @Override
    public double getLength() {
        return length;
    }

    @Override
    public double getWidth() {
        return width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
