package org.example.framework.beans;

import lombok.Data;

/**
 * @Title: BeanDefinition
 * @Author Hannibal
 * @Package org.example.framework.beans
 * @Date 06/08/2023 21:29
 * @Description: 用于封装bean标签数据
 */
@Data
public class BeanDefinition {
    private String id;
    private String className;
    private MutablePropertyValue propertyValue;

    public BeanDefinition() {
        propertyValue = new MutablePropertyValue();
    }

}
