package org.example.principle.interfaceSegregationPrinciple;

import org.junit.jupiter.api.Test;

/**
 * @Title: SafetyDoorDemo
 * @Author Hannibal
 * @Package org.example.principle.interfaceSegregationPrinciple
 * @Date 23/07/2023 14:57
 * @Description: TODO
 */
public class SafetyDoorDemo {
    @Test
    public void test() {
        SafetyDoor door = new SafetyDoor();
        door.run();
    }
}
