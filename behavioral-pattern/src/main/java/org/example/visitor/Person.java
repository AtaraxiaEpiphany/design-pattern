package org.example.visitor;

import org.example.visitor.impl.Cat;
import org.example.visitor.impl.Dog;

/**
 * @Title: Person
 * @Author Hannibal
 * @Package org.example.visitor
 * @Date 06/08/2023 11:44
 * @Description: TODO Visitor 抽象访问者
 */
public interface Person {
    void feed(Cat cat);
    void feed(Dog dog);

}
