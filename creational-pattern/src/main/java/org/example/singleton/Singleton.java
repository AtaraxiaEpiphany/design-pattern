package org.example.singleton;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import static com.common.util.ConsoleLogUtil.FG_YELLOW;

/**
 * @Title: Singleton 单例类
 * @Author Hannibal
 * @Package org.example.singleton
 * @Date 23/07/2023 17:11
 * @Description: TODO
 */
public class Singleton implements Serializable {

    @Test
    public void testSingleton() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("ipconfig");
        InputStream is = process.getInputStream();
        byte[] bytes = new byte[1024 * 1024 * 100];
        int len = is.read(bytes);
        FG_YELLOW.print(new String(bytes, 0, len));
    }

}
