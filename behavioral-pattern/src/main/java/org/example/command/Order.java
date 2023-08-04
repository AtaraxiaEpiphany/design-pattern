package org.example.command;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: Order 订单
 * @Author Hannibal
 * @Package org.example.command
 * @Date 04/08/2023 21:38
 * @Description:
 */
public class Order {
    /**
     * 餐桌号,食物名称及数量
     */
    private String tableId;
    private Map<String, Integer> foodDir = new HashMap<>();

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public Map<String, Integer> getFoodDir() {
        return foodDir;
    }

    public void setFood(String foodName, Integer number) {
        this.foodDir.put(foodName, number);
    }
}
