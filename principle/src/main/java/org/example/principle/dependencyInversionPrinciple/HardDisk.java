package org.example.principle.dependencyInversionPrinciple;

/**
 * @Title: HardDisk 硬盘
 * @Author Hannibal
 * @Package org.example.principle.dependencyInversionPrinciple
 * @Date 23/07/2023 14:07
 * @description: TODO
 */
public interface HardDisk {
    void save(Object data);

    Object get();
}
