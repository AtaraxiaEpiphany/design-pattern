package org.example.singleton.destroy;

import com.common.util.LogUtil;
import org.example.singleton.Singleton;
import org.example.singleton.pattern.LazySingletonPattern;
import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @Title: DestroyDemo
 * @Author Hannibal
 * @Package org.example.singleton.destroy
 * @Date 23/07/2023 19:25
 * @Description: 反序列化破坏单例
 */
public class DestroyBySerializable {
    private String path = "D:\\Codes\\design-patter\\Lectures\\tmp\\singleton.txt";

    private void write2file() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        Singleton singleton = LazySingletonPattern.getSingletonWithDoubleCheck();
        oos.writeObject(singleton);
        oos.close();
    }

    private Singleton readFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        Singleton singleton = (Singleton) ois.readObject();
        ois.close();
        return singleton;
    }

    @Test
    public void testDestroyBySerializable() throws IOException, ClassNotFoundException {
        write2file();
        /**
         * read object最终是通过反射创建的对象.
         */
        Singleton s1 = readFromFile();
        Singleton s2 = readFromFile();
        LogUtil.FG_GREEN.print("s1 ==> %s", s1);
        LogUtil.FG_GREEN.print("s2 ==> %s", s2);
    }
}
