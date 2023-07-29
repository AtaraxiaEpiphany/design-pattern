package org.example.adapter.classAdapter.impl;

import org.example.adapter.classAdapter.SDCard;

import static com.common.util.LogUtil.FG_GREEN;

/**
 * @Title: SDCardImpl SD卡实现类
 * @Author Hannibal
 * @Package org.example.adapter.classAdapter.impl
 * @Date 29/07/2023 10:52
 * @Description: TODO 目标接口实现类
 */
public class SDCardImpl implements SDCard {
    @Override
    public String readSD() {
        return FG_GREEN.getCode("Read from SD Card...");
    }

    @Override
    public void write2SD(String data) {
        FG_GREEN.print("Write (%s) to SD Card...", data);
    }
}
