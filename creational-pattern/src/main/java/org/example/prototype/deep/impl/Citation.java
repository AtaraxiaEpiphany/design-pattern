package org.example.prototype.deep.impl;

import org.example.prototype.deep.Student;

import static com.common.util.LogUtil.FG_YELLOW;

/**
 * @Title: Citation 奖状原型类
 * @Author Hannibal
 * @Package org.example.prototype.deep.impl
 * @Date 25/07/2023 22:39
 * @Description: TODO
 */
public class Citation implements Cloneable {

    private Student student;

    public Student getStudent() {
        return student;
    }


    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public Citation clone() throws CloneNotSupportedException {
        FG_YELLOW.print("复制奖状...");
        return (Citation) super.clone();
    }

    public void show() {
        FG_YELLOW.print("%s 获得了奖状Citation.", this.student.getName());
    }
}
