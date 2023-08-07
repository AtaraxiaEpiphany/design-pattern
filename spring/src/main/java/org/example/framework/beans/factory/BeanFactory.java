package org.example.framework.beans.factory;

/**
 * @Title: BeanFactory
 * @Author Hannibal
 * @Package org.example.framework.beans.factory
 * @Date 07/08/2023 20:22
 * @Description: TODO IOC容器父接口
 */
public interface BeanFactory {
    Object getBean(String name) throws Exception;

    <T> T getBean(String name, Class<? extends T> clazz) throws Exception;
}
