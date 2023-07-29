package org.example.decorator;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static com.common.util.LogUtil.FG_YELLOW;

/**
 * @Title: Advanced 装饰器模式扩展
 * @Author Hannibal
 * @Package org.example.decorator
 * @Date 29/07/2023 16:15
 * @Description: 扩展
 */
public class Advanced {
    private static Component apply(Component c) {
        // 创建匿名类作为装饰器
        return new Component() {
            private final Component wrappedComponent = c;

            @Override
            public void operation() {
                // 添加额外的操作
                FG_YELLOW.print("执行额外的操作...");
                // 调用被包装的组件的操作
                wrappedComponent.operation();
            }
        };
    }

    @Test
    public void test() {
        // 创建具体组件对象
        Component component = new ConcreteComponent();
        // 使用装饰器工厂创建装饰器,动态传入Function创建具体产品.
        Component decoratedComponent = DecoratorFactory.createDecorator(component, Advanced::apply);
        // 调用装饰后的操作
        decoratedComponent.operation();
    }
}

/**
 * 定义抽象组件,抽象产品
 */
interface Component {
    void operation();
}

/**
 * 定义具体组件,具体产品
 */
class ConcreteComponent implements Component {
    @Override
    public void operation() {
        FG_YELLOW.print("执行具体组件的操作...");
    }
}

/**
 * 定义装饰器工厂类,抽象工厂.
 */
class DecoratorFactory {
    /**
     * @param component         Concrete Component 具体组件
     * @param decoratorFunction
     * @return 装饰器实现了抽象组件, 并持有一个具体组件的引用.
     */
    public static Component createDecorator(Component component, Function<Component, Component> decoratorFunction) {
        return decoratorFunction.apply(component);
    }
}