package org.example.mediator.impl;

import org.example.mediator.Mediator;
import org.example.mediator.Person;

import static com.common.util.LogUtil.FG_YELLOW;

/**
 * @Title: HouseOwner 房主
 * @Author Hannibal
 * @Package org.example.mediator.impl
 * @Date 06/08/2023 10:38
 * @Description: TODO Concrete Colleague
 */
public class HouseOwner extends Person {
    public HouseOwner(Mediator mediator) {
        super(mediator);
    }

    public HouseOwner(String name, Mediator mediator) {
        super(mediator);
        super.name = name;
    }

    @Override
    public void getMessage(String message) {
        FG_YELLOW.print("房主:name ==> %s,message ==> %s", name, message);
    }

    public void contact(String message) {
        mediator.contact(message, this);
    }
}

