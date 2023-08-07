package org.example.framework.beans.factory.xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.example.framework.beans.BeanDefinition;
import org.example.framework.beans.MutablePropertyValue;
import org.example.framework.beans.PropertyValue;
import org.example.framework.beans.factory.support.BeanDefinitionReader;
import org.example.framework.beans.factory.support.BeanDefinitionRegistry;
import org.example.framework.beans.factory.support.impl.SimpleBeanDefinitionRegistry;

import java.io.InputStream;
import java.util.List;

import static org.example.framework.constant.PropertyConst.*;

/**
 * @Title: XMLBeanDefinitionReader
 * @Author Hannibal
 * @Package org.example.framework.beans.factory.xml
 * @Date 06/08/2023 21:43
 * @Description: TODO xml配置文件解析
 */
@SuppressWarnings({"unused"})
public class XMLBeanDefinitionReader implements BeanDefinitionReader {

    private BeanDefinitionRegistry registry;

    public XMLBeanDefinitionReader() {
        registry = new SimpleBeanDefinitionRegistry();
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public void loadBeanDefinition(String configLocation) throws Exception {
        SAXReader reader = new SAXReader();
        /**
         * 获取类路径下的配置文件.
         */
        InputStream is = XMLBeanDefinitionReader.class.getClass()
                .getResourceAsStream(configLocation);
        Document read = reader.read(is);
        Element rootElement = read.getRootElement();
        List<Element> elements = rootElement.elements(BEAN_ELEMENT_NAME);
        for (Element element : elements) {
            // 获取ID
            String name = element.attributeValue(ID);
            // 获取Class
            String className = element.attributeValue(CLASS_NAME);
            BeanDefinition beanDefinition = new BeanDefinition();
            beanDefinition.setId(name);
            beanDefinition.setClassName(className);
            /**
             * 获取bean标签下所有的property
             */
            List<Element> properties = element.elements(PROPERTY_NAME);
            MutablePropertyValue propertyValues = new MutablePropertyValue();
            for (Element property : properties) {
                String nameAttribute = property.attributeValue(NAME);
                String refAttribute = property.attributeValue(REF);
                String value = property.attributeValue(VALUE);
                PropertyValue propertyValue = new PropertyValue(nameAttribute, refAttribute, value);
                propertyValues.add(propertyValue);
            }
            /**
             * 封装到beanDefinition中
             */
            beanDefinition.setPropertyValue(propertyValues);
            /**
             * 注册到注册表中.
             */
            registry.registerBeanDefinition(name, beanDefinition);
        }
    }
}
