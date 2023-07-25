package org.example.prototype.deep;

import org.example.prototype.deep.impl.Citation;
import org.example.prototype.deep.impl.DeepCitation;
import org.junit.jupiter.api.Test;

/**
 * @Title: ClientDemoTest 客户端
 * @Author Hannibal
 * @Package org.example.prototype.deep
 * @Date 25/07/2023 22:39
 * @Description: TODO 访问类
 */
public class ClientDemoTest {
    @Test
    public void testShallow() throws CloneNotSupportedException {
        /**
         * Prototype Object.
         */
        Citation citation = new Citation();
        Student student = new Student();
        student.setName("ZhangSan");
        citation.setStudent(student);

        /**
         * Shallow copy.
         */
        Citation clone = citation.clone();
        /**
         * Set student name.
         */
        clone.getStudent().setName("WangWu");

        citation.show(); // WangWu....
        clone.show(); // WangWu....

    }

    @Test
    public void testDeep() throws CloneNotSupportedException {
        DeepCitation deepCitation = new DeepCitation();
        Student student = new Student();
        student.setName("ZhangSan");
        deepCitation.setStudent(student);

        DeepCitation clone = deepCitation.clone();
        clone.getStudent().setName("WangWu");

        deepCitation.show();
        clone.show();
    }
}
