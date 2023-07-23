package org.example.principle.dependencyInversionPrinciple;

import org.example.principle.dependencyInversionPrinciple.impl.IntelCpu;
import org.example.principle.dependencyInversionPrinciple.impl.KingstonMemory;
import org.example.principle.dependencyInversionPrinciple.impl.XiShuHardDisk;
import org.junit.jupiter.api.Test;

/**
 * @Title: ComputerDemo
 * @Author Hannibal
 * @Package org.example.principle.dependencyInversionPrinciple
 * @Date 23/07/2023 14:29
 * @description: TODO
 */
public class ComputerDemo {
    @Test
    public void test() {
        Computer computer = new Computer();
        HardDisk hardDisk = new XiShuHardDisk();
        Memory memory = new KingstonMemory();
        Processor processor = new IntelCpu();
        //组装电脑
        computer.setMemory(memory);
        computer.setProcessor(processor);
        computer.setHardDisk(hardDisk);
        computer.run();
    }
}
