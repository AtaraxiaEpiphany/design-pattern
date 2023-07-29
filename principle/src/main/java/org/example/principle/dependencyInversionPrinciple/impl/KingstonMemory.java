package org.example.principle.dependencyInversionPrinciple.impl;

import com.common.util.LogUtil;
import org.apache.tomcat.util.log.SystemLogHandler;
import org.example.principle.dependencyInversionPrinciple.Memory;

import static com.common.util.LogUtil.FG_GREEN;

/**
 * @Title: KingstonMemory 金士顿内存条
 * @Author Hannibal
 * @Package org.example.principle.dependencyInversionPrinciple.impl
 * @Date 23/07/2023 14:25
 * @description: TODO
 */
public class KingstonMemory implements Memory {

    @Override
    public void save() {
        FG_GREEN.print("Kingston memory save data...");
    }
}
