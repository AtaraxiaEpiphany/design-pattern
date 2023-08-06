package org.example.mediator.impl;

import org.example.mediator.Mediator;
import org.example.mediator.Person;

import static com.common.util.LogUtil.FG_YELLOW;

/**
 * @Title: Tenant 租客
 * @Author Hannibal
 * @Package org.example.mediator.impl
 * @Date 06/08/2023 10:34
 * @Description: TODO Concrete Colleague 具体同事对象
 */
public class Tenant extends Person {

    public Tenant(String name, Mediator mediator) {
        super(mediator);
        super.name = name;
    }

    public Tenant(Mediator mediator) {
        super(mediator);
    }

    /**
     * 与中介沟通
     *
     * @param message
     */
    public void contact(String message) {
        mediator.contact(message, this);
    }

    public void getMessage(String message) {
        FG_YELLOW.print("租房者:name ==> %s,message ==> %s", name, message);
    }
}
