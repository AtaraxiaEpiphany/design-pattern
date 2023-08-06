package org.example.mediator;

/**
 * @Title: Person
 * @Author Hannibal
 * @Package org.example.mediator
 * @Date 06/08/2023 10:32
 * @Description: Colleague 同事对象
 */
public abstract class Person {
    protected String name;
    protected Mediator mediator;

    public Person(Mediator mediator) {
        this.mediator = mediator;
    }
    public abstract void getMessage(String message);
}
