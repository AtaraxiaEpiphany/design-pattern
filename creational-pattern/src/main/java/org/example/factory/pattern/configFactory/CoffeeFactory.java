package org.example.factory.pattern.configFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

/**
 * @Title: CoffeeFactory 简单工厂
 * @Author Hannibal
 * @Package org.example.factory.pattern.configFactory
 * @Date 24/07/2023 23:04
 * @Description: TODO
 */
public class CoffeeFactory {

    /**
     * 定义容器存储咖啡对象.
     */
    private static HashMap<String, Coffee> map = new HashMap<>();

    static {
        /**
         * 配置文件只需加载一次,因此设置为static.
         */
        Properties properties = new Properties();
        InputStream is = CoffeeFactory.class.getClassLoader().getResourceAsStream("coffee.properties");
        /**
         * 通过反射创建咖啡对象.
         */
        try {
            properties.load(is);
            for (Object key : properties.keySet()) {
                String name = (String) properties.get(key);
                Class<?> coffeeClass = Class.forName(name);
                Coffee coffee = (Coffee) coffeeClass.newInstance();
                map.put((String) key, coffee);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static Coffee createCoffee(String name) {
        return map.get(name);
    }


}
