package org.example.principle.dependencyInversionPrinciple.impl;

import com.common.util.ConsoleLogUtil;
import org.example.principle.dependencyInversionPrinciple.Processor;

import static com.common.util.ConsoleLogUtil.FG_YELLOW;

/**
 * @Title: IntelCpu 因特尔cpu
 * @Author Hannibal
 * @Package org.example.principle.dependencyInversionPrinciple.impl
 * @Date 23/07/2023 14:20
 * @description: TODO
 */
public class IntelCpu implements Processor {
    @Override
    public void run() {
        FG_YELLOW.print("Intel Cpu is running...");
    }
}
