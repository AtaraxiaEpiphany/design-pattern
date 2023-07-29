package org.example.decorator;

import org.example.decorator.impl.Bacon;
import org.example.decorator.impl.Egg;
import org.example.decorator.impl.FriedNoodle;
import org.example.decorator.impl.FriedRice;
import org.junit.jupiter.api.Test;

import static com.common.util.LogUtil.FG_YELLOW;

/**
 * @Title: ClientDemoTest
 * @Author Hannibal
 * @Package org.example.decorator
 * @Date 29/07/2023 15:52
 * @Description: TODO
 */
public class ClientDemoTest {
    @Test
    public void test() {
        FastFood friedRice = new FriedRice();
        FG_YELLOW.print(friedRice.getDesc() + " ==>" + friedRice.cost());

        /**
         * 鸡蛋炒饭, 装饰器
         */
        FastFood eggDecorator = new Egg(friedRice);
        FG_YELLOW.print(eggDecorator.getDesc() + " ==>" + eggDecorator.cost());
        /**
         * 培根炒面
         */
        FastFood friedNoodle = new FriedNoodle();
        FastFood baconDecorator = new Bacon(friedNoodle);
        FG_YELLOW.print(baconDecorator.getDesc() + " ==>" + baconDecorator.cost());
        /**
         * 培根炒面 + 鸡蛋
         */
        FastFood fastFood = new Egg(baconDecorator);
        FG_YELLOW.print(fastFood.getDesc() + " ==>" + fastFood.cost());

    }
}
