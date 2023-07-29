package org.example.prototype.deep.impl;

import cn.hutool.json.JSONUtil;
import org.example.prototype.deep.Student;

import static com.common.util.LogUtil.FG_YELLOW;

/**
 * @Title: DeepCitation 原型类
 * @Author Hannibal
 * @Package org.example.prototype.deep.impl
 * @Date 25/07/2023 22:50
 * @Description: 深克隆:使用序列化
 */
public class DeepCitation implements Cloneable {

    private Student student;

    public Student getStudent() {
        return student;
    }


    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public DeepCitation clone() throws CloneNotSupportedException {
        FG_YELLOW.print("复制奖状...");
        DeepCitation clone = (DeepCitation) super.clone();
        String jsonStr = JSONUtil.toJsonStr(clone.student);
        Student bean = JSONUtil.toBean(jsonStr, Student.class);
        clone.setStudent(bean);
        return clone;
    }

    public void show() {
        FG_YELLOW.print("%s 获得了奖状Citation.", this.student.getName());
    }
}
