package org.example.framework.context;

import org.example.framework.beans.factory.BeanFactory;

/**
 * @Title: ApplicationContext
 * @Author Hannibal
 * @Package org.example.framework.constant
 * @Date 07/08/2023 20:24
 * @Description: 非延时加载
 */
public interface ApplicationContext extends BeanFactory {
    void refresh() throws Exception;
}
