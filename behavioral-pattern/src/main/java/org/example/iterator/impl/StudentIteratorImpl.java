package org.example.iterator.impl;

import org.example.iterator.Student;
import org.example.iterator.StudentIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: StudentIterator 学生迭代器
 * @Author Hannibal
 * @Package org.example.iterator.impl
 * @Date 06/08/2023 11:13
 * @Description: TODO Concrete Iterator
 */
public class StudentIteratorImpl implements StudentIterator {
    private List<Student> list = new ArrayList<>();

    public void setList(List<Student> list) {
        this.list = list;
    }

    private int wizard = 0;

    @Override
    public boolean hasNext() {
        return wizard < list.size();
    }

    @Override
    public Student next() {
        return list.get(wizard++);
    }
}
