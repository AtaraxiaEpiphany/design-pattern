package org.example.principle.liskovSubstitutionPrinciple.fault;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static com.common.util.ConsoleLogUtil.FG_GREEN;
import static com.common.util.ConsoleLogUtil.FG_YELLOW;

/**
 * @Title: RectangleDemo
 * @Author Hannibal
 * @Package org.example.principle.LiskovSubstitutionPrinciple
 * @Date 23/07/2023 11:32
 * @description: TODO
 */
public class RectangleDemo {
    @Test
    public void testRectangle() {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(10);
        rectangle.setLength(20);
        resize(rectangle);
    }

    /**
     * Square类违反了里氏代换原则(重写了父类的方法)
     */
    @Test
    public void testSquare() {
        Rectangle rectangle = new Square();
        rectangle.setLength(10);
        // Endless loop
        resize(rectangle);
    }

    /**
     * 扩宽
     *
     * @param rectangle
     */
    public void resize(Rectangle rectangle) {
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

    public void show(Rectangle rectangle) {
        FG_GREEN.print("height ==> %s", rectangle.getLength());
        FG_YELLOW.print("width ==> %s", rectangle.getWidth());
    }
}
