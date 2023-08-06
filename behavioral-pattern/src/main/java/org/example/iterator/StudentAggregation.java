package org.example.iterator;

/**
 * @Title: StudentAggregation 聚合学生对象
 * @Author Hannibal
 * @Package org.example.iterator
 * @Date 06/08/2023 11:10
 * @Description: TODO Aggregation 聚合对象
 */
public interface StudentAggregation {
    void addStudent(Student student);

    void removeStudent(Student student);

    StudentIterator getStudentIterator();
}
