package org.example.visitor.impl;

import org.example.visitor.Person;

import static com.common.util.LogUtil.FG_GREEN;

/**
 * @Title: Owner
 * @Author Hannibal
 * @Package org.example.visitor.impl
 * @Date 06/08/2023 11:48
 * @Description: TODO Concrete visitor 具体访问者
 */
public class Owner implements Person {
    @Override
    public void feed(Cat cat) {
        FG_GREEN.print("Owner, feed cat");
    }

    @Override
    public void feed(Dog dog) {
        FG_GREEN.print("Owner, feed dog");
    }
}
