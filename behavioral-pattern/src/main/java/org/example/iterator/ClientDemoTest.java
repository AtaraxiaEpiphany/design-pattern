package org.example.iterator;

import org.example.iterator.impl.StudentAggregationImpl;
import org.junit.jupiter.api.Test;

import static com.common.util.LogUtil.FG_YELLOW;

/**
 * @Title: ClientDemoTest
 * @Author Hannibal
 * @Package org.example.iterator
 * @Date 06/08/2023 11:23
 * @Description: TODO
 */
public class ClientDemoTest {
    @Test
    public void test() {
        StudentAggregation studentAggregation = new StudentAggregationImpl();
        studentAggregation.addStudent(new Student("one", "Hannibal"));
        studentAggregation.addStudent(new Student("two", "Ataraxia"));
        studentAggregation.addStudent(new Student("three", "Epiphany"));
        studentAggregation.addStudent(new Student("four", "Tulips"));

        StudentIterator studentIterator = studentAggregation.getStudentIterator();
        while (studentIterator.hasNext()){
            Student next = studentIterator.next();
            FG_YELLOW.print("next ==> " + next);
        }
    }

}
