package org.example.visitor;

import org.example.visitor.impl.Cat;
import org.example.visitor.impl.Dog;
import org.example.visitor.impl.Owner;
import org.example.visitor.impl.Someone;
import org.junit.jupiter.api.Test;

/**
 * @Title: ClientDemoTest
 * @Author Hannibal
 * @Package org.example.visitor
 * @Date 06/08/2023 11:52
 * @Description: TODO
 */
public class ClientDemoTest {
    @Test
    public void test() {
        Home home = new Home();
        home.add(new Cat());
        home.add(new Dog());

        Person owner = new Owner();
        Person someone = new Someone();
        /**
         * 喂食所有宠物.
         */
        home.action(owner);
    }
}
