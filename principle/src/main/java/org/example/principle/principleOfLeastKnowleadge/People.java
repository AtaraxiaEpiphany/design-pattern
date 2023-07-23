package org.example.principle.principleOfLeastKnowleadge;

/**
 * @Title: People
 * @Author Hannibal
 * @Package org.example.principle.principleOfLeastKnowleadge
 * @Date 23/07/2023 15:15
 * @Description: TODO
 */
public abstract class People {
    private String name;

    public People(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
