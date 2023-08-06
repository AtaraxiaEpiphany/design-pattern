package org.example.visitor;

/**
 * @Title: Animal
 * @Author Hannibal
 * @Package org.example.visitor
 * @Date 06/08/2023 11:45
 * @Description: TODO Element 抽象元素(被访问者)
 */
public interface Animal {
    void accept(Person person);
}
