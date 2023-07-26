package org.example.builder;

/**
 * @Title: Bike 自行车
 * @Author Hannibal
 * @Package org.example.builder
 * @Date 26/07/2023 21:15
 * @Description: TODO 产品类
 */
public class Bike {
    /**
     * 车架
     */
    private String frame;
    /**
     * 车座
     */
    private String seat;

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}
