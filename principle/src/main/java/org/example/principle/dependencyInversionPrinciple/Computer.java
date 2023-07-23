package org.example.principle.dependencyInversionPrinciple;

import com.common.util.ConsoleLogUtil;

import static com.common.util.ConsoleLogUtil.*;

/**
 * @Title: Computer 主机
 * @Author Hannibal
 * @Package org.example.principle.dependencyInversionPrinciple
 * @Date 23/07/2023 14:12
 * @description:
 */
public class Computer {
    private HardDisk hardDisk;
    private Memory memory;
    private Processor processor;

    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public void run() {
        FG_RED.print("Computer is loading...");
        FG_YELLOW.print("从磁盘加载数据:%s", hardDisk.get());
        memory.save();
        processor.run();
        FG_RED.print("Computer loading finished.");
    }
}
