package org.example.visitor.impl;

import org.example.visitor.Animal;
import org.example.visitor.Person;

import static com.common.util.LogUtil.FG_YELLOW;

/**
 * @Title: Cat
 * @Author Hannibal
 * @Package org.example.visitor.impl
 * @Date 06/08/2023 11:46
 * @Description: TODO Concrete Element 具体元素(被访问者)
 */
public class Cat implements Animal {
    @Override
    public void accept(Person person) {
        person.feed(this);
        FG_YELLOW.print("Cat, person ==> %s", person);
    }
}
