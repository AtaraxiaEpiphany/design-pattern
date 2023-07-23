package org.example.singleton.destroy;

import com.common.util.ConsoleLogUtil;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Title: DestroyByReflect 反射破坏单例
 * @Author Hannibal
 * @Package org.example.singleton.destroy
 * @Date 23/07/2023 19:53
 * @Description: TODO
 */
public class DestroyByReflect {
    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Singleton> singletonClass = Singleton.class;
        Constructor<?> declaredConstructors = singletonClass.getDeclaredConstructor();
        boolean accessible = declaredConstructors.isAccessible();
        if (!accessible) {
            declaredConstructors.setAccessible(true);
        }
        Singleton singleton1 = (Singleton) declaredConstructors.newInstance();
        Singleton singleton2 = (Singleton) declaredConstructors.newInstance();

        ConsoleLogUtil.FG_GREEN.print("singleton1 ==> " + singleton1);
        ConsoleLogUtil.FG_GREEN.print("singleton2 ==> " + singleton2);

        declaredConstructors.setAccessible(accessible);
    }
}
