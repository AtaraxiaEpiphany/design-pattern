package org.example.principle.dependencyInversionPrinciple.impl;

import com.common.util.LogUtil;
import org.example.principle.dependencyInversionPrinciple.HardDisk;

import static com.common.util.LogUtil.FG_YELLOW;

/**
 * @Title: XiShuHardDisk 西数硬盘
 * @Author Hannibal
 * @Package org.example.principle.dependencyInversionPrinciple.impl
 * @Date 23/07/2023 14:27
 * @description: TODO
 */
public class XiShuHardDisk implements HardDisk {

    @Override
    public void save(Object data) {
        FG_YELLOW.print("西数硬盘保存数据中...");
    }

    @Override
    public Object get() {
        return "从西数硬盘中获取的数据.";
    }
}
