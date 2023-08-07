package org.example.framework.beans;

import lombok.NonNull;

import java.util.*;

/**
 * @Title: MutablePropertyValue
 * @Author Hannibal
 * @Package org.example.framework.beans.factory
 * @Date 06/08/2023 21:03
 * @Description: Aggregation, 聚合对象, 采用迭代器模式用于存储和管理多个propertyValue
 */
@SuppressWarnings({"unused"})
public class MutablePropertyValue implements Iterable<PropertyValue> {
    private final List<PropertyValue> list;

    public MutablePropertyValue() {
        list = new ArrayList<>();
    }

    public MutablePropertyValue(List<PropertyValue> list) {
        if (Objects.isNull(list)) {
            this.list = new ArrayList<>();
        } else {
            this.list = list;
        }
    }

    /**
     * @return 获取所有的propertyValue对象.
     */
    public PropertyValue[] getPropertyValues() {
        return list.toArray(PropertyValue[]::new);
    }

    public PropertyValue getPropertyValue(@NonNull String propertyName) {
        for (PropertyValue propertyValue : list) {
            if (Objects.equals(propertyName, propertyValue.getName())) {
                return propertyValue;
            }
        }
        return null;
    }

    /**
     * 链式编程
     *
     * @param propertyValue
     * @return
     */
    public MutablePropertyValue add(PropertyValue propertyValue) {
        for (int i = 0; i < list.size(); i++) {
            PropertyValue current = list.get(i);
            /**
             * 重名bean
             */
            if (Objects.equals(current.getName(), propertyValue.getName())) {
                list.set(i, propertyValue);
                return this;
            }
        }
        list.add(propertyValue);
        return this;
    }

    public boolean contains(String propertyName) {
        return Objects.nonNull(getPropertyValue(propertyName));
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Iterator<PropertyValue> iterator() {
        return list.iterator();
    }


}
