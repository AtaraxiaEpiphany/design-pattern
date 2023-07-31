package org.example.facade;

import static com.common.util.LogUtil.FG_GREEN;

/**
 * @Title: TV 电视机类
 * @Author Hannibal
 * @Package org.example.facade
 * @Date 31/07/2023 20:57
 * @Description: TODO Subsystem
 */
public class TV {

    public void on() {
        FG_GREEN.print("打开电视机...");
    }

    public void off() {
        FG_GREEN.print("关闭电视机..");
    }
}
