package org.example.principle.liskovSubstitutionPrinciple.correct;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static com.common.util.ConsoleLogUtil.FG_GREEN;
import static com.common.util.ConsoleLogUtil.FG_YELLOW;

/**
 * @Title: QuadrangleDemo
 * @Author Hannibal
 * @Package org.example.principle.LiskovSubstitutionPrinciple.correct
 * @Date 23/07/2023 11:53
 * @description: TODO
 */
public class QuadrangleDemo {
    @Test
    public void test() {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(10);
        rectangle.setLength(20);
        resize(rectangle);
        /**
         * 正方形有自己独特的方法,长方形无法被替换.
         */
//        resize(new Square());
    }

    private void resize(Rectangle rectangle) {
        while (rectangle.getWidth() <= rectangle.getLength()) {
            rectangle.setWidth(rectangle.getWidth() + 1);
            show(rectangle);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void show(Quadrangle quadrangle) {
        FG_GREEN.print("height ==> %s", quadrangle.getLength());
        FG_YELLOW.print("width ==> %s", quadrangle.getWidth());
    }
}
