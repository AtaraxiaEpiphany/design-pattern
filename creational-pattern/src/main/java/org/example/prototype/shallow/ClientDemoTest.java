package org.example.prototype.shallow;

import org.example.prototype.shallow.impl.Citation;
import org.junit.jupiter.api.Test;

/**
 * @Title: ClientDemoTest 客户端
 * @Author Hannibal
 * @Package org.example.prototype.shallow
 * @Date 25/07/2023 21:32
 * @Description: TODO 访问类
 */
public class ClientDemoTest {
    @Test
    public void testCloneable() throws CloneNotSupportedException {
        /**
         * Prototype object.
         */
        Citation citation = new Citation();
        /**
         * 复制奖状.
         */
        Citation clone = citation.clone();

        /**
         * String is mutable.
         */
        citation.setStudentName("ZhangSan");
        clone.setStudentName("WangWu");

        citation.show();
        clone.show();
    }
}
