package org.example.principle.liskovSubstitutionPrinciple.correct;

/**
 * @Title: Square
 * @Author Hannibal
 * @Package org.example.principle.LiskovSubstitutionPrinciple.correct
 * @Date 23/07/2023 11:50
 * @description: TODO
 */
public class Square implements Quadrangle {

    private double side;

    @Override
    public double getLength() {
        return side;
    }

    @Override
    public double getWidth() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}
