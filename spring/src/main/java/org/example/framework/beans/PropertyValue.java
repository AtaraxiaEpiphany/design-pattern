package org.example.framework.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: PropertyValue
 * @Author Hannibal
 * @Package org.example.framework.beans
 * @Date 06/08/2023 20:59
 * @Description: 用于封装bean标签的property属性
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyValue {
    /**
     * bean name.
     */
    private String name;
    /**
     * bean reference.
     */
    private String ref;
    /**
     * bean value.
     */
    private String value;

}
