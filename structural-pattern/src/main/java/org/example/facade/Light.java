package org.example.facade;

import static com.common.util.LogUtil.FG_GREEN;

/**
 * @Title: Light 电灯类
 * @Author Hannibal
 * @Package org.example.facade
 * @Date 31/07/2023 20:56
 * @Description: TODO Subsystem 子系统
 */
public class Light {
    public void on() {
        FG_GREEN.print("打开电灯...");
    }

    public void off() {
        FG_GREEN.print("关闭电灯...");
    }
}
