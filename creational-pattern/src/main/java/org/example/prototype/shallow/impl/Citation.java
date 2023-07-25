package org.example.prototype.shallow.impl;

import static com.common.util.ConsoleLogUtil.FG_YELLOW;

/**
 * @Title: Citation 奖状原型类/sai'teition/
 * @Author Hannibal
 * @Package org.example.prototype.shallow.impl
 * @Date 25/07/2023 22:27
 * @Description: TODO
 */
public class Citation implements Cloneable {
    /**
     * 学生姓名:
     */
    private String studentName;

    @Override
    public Citation clone() throws CloneNotSupportedException {
        FG_YELLOW.print("复制奖状...");
        return (Citation) super.clone();
    }

    public void show() {
        FG_YELLOW.print("%s 获得了奖状Citation.", this.studentName);
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

}
