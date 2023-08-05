package org.example.observer;


/**
 * @Title: Subject
 * @Author Hannibal
 * @Package org.example.observer
 * @Date 05/08/2023 21:13
 * @Description: Subject 抽象主题
 */
public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notify(String message);
}
