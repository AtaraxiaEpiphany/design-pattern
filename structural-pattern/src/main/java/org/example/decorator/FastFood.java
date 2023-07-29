package org.example.decorator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: FastFood 快餐
 * @Author Hannibal
 * @Package org.example.decorator
 * @Date 29/07/2023 15:27
 * @Description: Component  抽象组件
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class FastFood {
    private float price;
    private String desc;

    public abstract float cost();


}
