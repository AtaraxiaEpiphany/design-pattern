package org.example.principle.liskovSubstitutionPrinciple.fault;

/**
 * @Title: Square 正方形
 * @Author Hannibal
 * @Package org.example.principle.LiskovSubstitutionPrinciple
 * @Date 23/07/2023 11:29
 * @description: 违反里氏代换原则
 */
public class Square extends Rectangle {
    /**
     * 重写了父类的方法
     *
     * @param length
     */
    @Override
    public void setLength(double length) {
        super.setLength(length);
        super.setWidth(length);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setLength(width);
    }
}
