package org.example.adapter.interfaceAdapter;

import static com.common.util.LogUtil.FG_GREEN;

/**
 * @Title: Computer 计算机类
 * @Author Hannibal
 * @Package org.example.adapter.classAdapter
 * @Date 29/07/2023 11:00
 * @Description: TODO
 */
public class Computer {
    public void readFromSD(SDCard sdCard) {
        String data = sdCard.readSD();
        FG_GREEN.print("Data read from SD in Computer ==> %s", data);
    }

    public void write2SD(SDCard sdCard) {
        sdCard.write2SD("Data from computer...");
    }
}
