package org.example.adapter.interfaceAdapter.impl;

import org.example.adapter.interfaceAdapter.TFCard;

import static com.common.util.LogUtil.FG_YELLOW;

/**
 * @Title: TFCardImpl TF卡实现类
 * @Author Hannibal
 * @Package org.example.adapter.classAdapter.impl
 * @Date 29/07/2023 10:48
 * @Description: TODO 适配者类
 */
public class TFCardImpl implements TFCard {
    @Override
    public String readTF() {
        return FG_YELLOW.getCode("Read from TF Card...");
    }

    @Override
    public void write2TF(String data) {
        FG_YELLOW.print("Write (%s) to TF card...", data);
    }
}
