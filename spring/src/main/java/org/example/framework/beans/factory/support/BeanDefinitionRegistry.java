package org.example.framework.beans.factory.support;

import org.example.framework.beans.BeanDefinition;

/**
 * @Title: BeanDefinitionRegistry bean注册表对象
 * @Author Hannibal
 * @Package org.example.framework.beans.factory.support
 * @Date 06/08/2023 21:32
 * @Description: 定义了向Spring容器注册Bean的方法
 */
public interface BeanDefinitionRegistry {
    /**
     * 注册beanDefinition对象到注册表中.
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    void removeBeanDefinition(String beanName) throws Exception;

    BeanDefinition getBeanDefinition(String beanName) throws Exception;

    boolean containsBeanDefinition(String beanName);

    int getBeanDefinitionCount();

    String[] getBeanDefinitionNames();
}
