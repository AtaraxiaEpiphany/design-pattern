package org.example.framework.context.support;

import org.example.framework.beans.BeanDefinition;
import org.example.framework.beans.MutablePropertyValue;
import org.example.framework.beans.PropertyValue;
import org.example.framework.beans.factory.support.BeanDefinitionRegistry;
import org.example.framework.beans.factory.xml.XMLBeanDefinitionReader;
import org.example.framework.utils.StringUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @Title: ClassPathXMLApplicationContext
 * @Author Hannibal
 * @Package org.example.framework.constant.support
 * @Date 07/08/2023 20:37
 * @Description: IOC容器具体子实现类
 */
public class ClassPathXMLApplicationContext extends AbstractApplicationContext {
    public ClassPathXMLApplicationContext(String configLocation) {
        this.configLocation = configLocation;
        beanDefinitionReader = new XMLBeanDefinitionReader();
        try {
            refresh();
        } catch (Exception ignore) {
        }
    }

    @Override
    public Object getBean(String name) throws Exception {
        Object o = singletonObjects.get(name);
        if (Objects.nonNull(o)) {
            return o;
        }
        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();
        BeanDefinition beanDefinition = registry.getBeanDefinition(name);
        String className = beanDefinition.getClassName();
        Class<?> clazz = Class.forName(className);
        Method[] declaredMethods = clazz.getDeclaredMethods();
        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
        Object instance = declaredConstructor.newInstance();
        /**
         * 依赖注入
         */
        MutablePropertyValue mutablePropertyValue = beanDefinition.getPropertyValue();
        for (PropertyValue propertyValue : mutablePropertyValue) {
            String ref = propertyValue.getRef();
            String propertyName = propertyValue.getName();
            String value = propertyValue.getValue();
            String setterMethodByFieldName = StringUtils.getSetterMethodByFieldName(propertyName);
            if (Objects.nonNull(ref) && !Objects.equals("", ref)) {
                //获取以来的bean对象
                Object object = getBean(ref);
                for (Method declaredMethod : declaredMethods) {
                    if (declaredMethod.getName().equals(setterMethodByFieldName)) {
                        declaredMethod.invoke(instance, object);
                        break;
                    }
                }
            }
            if (Objects.nonNull(value) && !Objects.equals("", value)) {
                Method method = clazz.getMethod(setterMethodByFieldName, String.class);
                method.invoke(instance, value);
            }
        }
        singletonObjects.put(name, instance);
        return instance;
    }

    @Override
    public <T> T getBean(String name, Class<? extends T> clazz) throws Exception {
        Object bean = getBean(name);
        if (Objects.isNull(null)) {
            return null;
        }
        return clazz.cast(bean);
    }
}
