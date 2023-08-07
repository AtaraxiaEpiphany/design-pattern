package org.example.framework.beans.factory.support;

/**
 * @Title: BeanDefinitionReader
 * @Author Hannibal
 * @Package org.example.framework.beans.factory.support
 * @Date 06/08/2023 21:41
 * @Description: TODO 用于解析配置文件,只定义规范
 */
public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();

    void loadBeanDefinition(String configLocation) throws Exception;
}
