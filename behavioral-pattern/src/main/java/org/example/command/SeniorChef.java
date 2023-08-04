package org.example.command;

import static com.common.util.LogUtil.FG_GREEN;

/**
 * @Title: SeniorChef 厨师类
 * @Author Hannibal
 * @Package org.example.command
 * @Date 04/08/2023 21:41
 * @Description: TODO Receiver 接受者
 */
public class SeniorChef {
    public void makeFood(String foodName, Integer number) {
        FG_GREEN.print("Made %s 数量 ==> %s...", foodName, number);
    }
}
