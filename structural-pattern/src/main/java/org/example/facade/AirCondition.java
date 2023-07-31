package org.example.facade;

import static com.common.util.LogUtil.FG_GREEN;

/**
 * @Title: AirCondition 空调类
 * @Author Hannibal
 * @Package org.example.facade
 * @Date 31/07/2023 20:58
 * @Description: Subsystem
 */
public class AirCondition {

    public void on() {
        FG_GREEN.print("打开空调...");
    }

    public void off() {
        FG_GREEN.print("关闭空调...");
    }
}
