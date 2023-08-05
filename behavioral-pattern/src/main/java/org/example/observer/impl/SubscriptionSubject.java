package org.example.observer.impl;

import org.example.observer.Observer;
import org.example.observer.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: SubscriptionSubject
 * @Author Hannibal
 * @Package org.example.observer.impl
 * @Date 05/08/2023 22:35
 * @Description: TODO Concrete Subject 具体主题角色
 */
public class SubscriptionSubject implements Subject {
    /**
     *
     */
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notify(String message) {
        observers.forEach(observer -> {
            observer.update(message);
        });
    }
}
