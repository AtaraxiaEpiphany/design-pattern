package org.example.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: Home
 * @Author Hannibal
 * @Package org.example.visitor
 * @Date 06/08/2023 11:50
 * @Description: TODO Object structure 对象结构类
 */
public class Home {
    private List<Animal> animals = new ArrayList<>();

    public void add(Animal animal) {
        animals.add(animal);
    }

    public void action(Person person) {
        animals.forEach(animal -> animal.accept(person));
    }
}
