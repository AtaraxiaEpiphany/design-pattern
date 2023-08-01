package org.example.flyweight;

import org.junit.jupiter.api.Test;

import static com.common.util.LogUtil.FG_GREEN;

/**
 * @Title: SourceCode 源码
 * @Author Hannibal
 * @Package org.example.flyweight
 * @Date 01/08/2023 21:04
 * @Description: TODO
 */
public class SourceCode {

    @Test
    public void test() {
        /**
         * Integer 使用到了 flyweight pattern.
         * String pool --> Flyweight pool.
         */
        Integer i1 = 127;
        Integer i2 = 127;
        Integer i3 = 128;
        Integer i4 = 128;
        FG_GREEN.print("i1 == i2 ==> %s", i1 == i2);
        FG_GREEN.print("i3 == i4 ==> %s", i3 == i4);
        /**
         *
         * public static Integer valueOf(int i) {
         *      if (i >= IntegerCache.low && i <= IntegerCache.high)
         *          return IntegerCache.cache[i + (-IntegerCache.low)];
         *      return new Integer(i);
         * }
         */
    }
}

