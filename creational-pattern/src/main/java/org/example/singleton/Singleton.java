package org.example.singleton;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static com.common.util.LogUtil.FG_GREEN;
import static com.common.util.LogUtil.FG_YELLOW;

/**
 * @Title: Singleton 单例类
 * @Author Hannibal
 * @Package org.example.singleton
 * @Date 23/07/2023 17:11
 * @Description: TODO
 */
public class Singleton implements Serializable {

    /**
     * Runtime 是一个单例对象.
     *
     * @throws IOException
     */
    @Test
    public void testSingleton() throws IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("ipconfig");
        InputStream is = process.getInputStream();
        byte[] bytes = new byte[1024 * 1024 * 100];
        int len = is.read(bytes);
        FG_YELLOW.print(new String(bytes, 0, len));
        /**
         * 破坏单例.
         */
        Class<Runtime> runtimeClass = Runtime.class;
        Constructor<Runtime> declaredConstructor = runtimeClass.getDeclaredConstructor();
        boolean accessible = declaredConstructor.isAccessible();
        Runtime rt = null;
        if (!accessible) {
            declaredConstructor.setAccessible(true);
            rt = declaredConstructor.newInstance();
            declaredConstructor.setAccessible(false);
        } else {
            rt = declaredConstructor.newInstance();
        }
        FG_GREEN.print("runtime ==> %s", runtime);
        FG_GREEN.print("rt ==> %s", rt);
    }

}
