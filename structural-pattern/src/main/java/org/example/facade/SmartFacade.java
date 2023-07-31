package org.example.facade;

/**
 * @Title: SmartFacade 智能控制类
 * @Author Hannibal
 * @Package org.example.facade
 * @Date 31/07/2023 20:59
 * @Description: TODO Facade 外观
 */
public class SmartFacade {
    /**
     * Aggregation
     */
    private Light light = new Light();
    private TV tv = new TV();
    private AirCondition airCondition = new AirCondition();

    /**
     * 语音控制
     */
    public void say(String message) {
        if (message.contains("open")) {
            on();
        } else if (message.contains("close")) {
            off();
        }
    }

    private void off() {
        tv.off();
        light.off();
        airCondition.off();
    }

    private void on() {
        tv.on();
        light.on();
        airCondition.on();
    }

}
