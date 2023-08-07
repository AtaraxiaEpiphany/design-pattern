package org.example.framework.context.support;

import org.example.framework.beans.factory.support.BeanDefinitionReader;
import org.example.framework.beans.factory.support.BeanDefinitionRegistry;
import org.example.framework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Title: AbstractApplicationContext
 * @Author Hannibal
 * @Package org.example.framework.constant.support
 * @Date 07/08/2023 20:27
 * @Description: ApplicationContext的子实现类, 用于立即加载.
 */
public abstract class AbstractApplicationContext implements ApplicationContext {
    /**
     * 声明解析器变量
     */
    protected BeanDefinitionReader beanDefinitionReader;
    /**
     * 存储bean的容器
     */
    protected Map<String, Object> singletonObjects = new HashMap<>();
    /**
     * 配置文件路径
     */
    protected String configLocation;

    @Override
    public void refresh() throws Exception {
        beanDefinitionReader.loadBeanDefinition(configLocation);
        finishBeanInitialization();
    }

    /**
     * bean的初始化.
     */
    private void finishBeanInitialization() throws Exception {
        //获取注册表
        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();
        //获取beanDefinition对象
        String[] beanDefinitionNames = registry.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = getBean(beanDefinitionName);
            singletonObjects.put(beanDefinitionName, bean);
        }
    }
}
