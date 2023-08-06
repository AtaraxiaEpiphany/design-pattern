package org.example.iterator.impl;

import org.example.iterator.Student;
import org.example.iterator.StudentAggregation;
import org.example.iterator.StudentIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: StudentAggregationImpl
 * @Author Hannibal
 * @Package org.example.iterator.impl
 * @Date 06/08/2023 11:16
 * @Description: TODO Concrete Aggregation
 */
public class StudentAggregationImpl implements StudentAggregation {
    private List<Student> list = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        list.add(student);
    }

    @Override
    public void removeStudent(Student student) {
        list.remove(student);
    }

    @Override
    public StudentIterator getStudentIterator() {
        StudentIteratorImpl studentIterator = new StudentIteratorImpl();
        studentIterator.setList(list);
        return studentIterator;
    }

}
