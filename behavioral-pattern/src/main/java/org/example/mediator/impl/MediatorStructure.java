package org.example.mediator.impl;

import org.example.mediator.Mediator;
import org.example.mediator.Person;

/**
 * @Title: MediatorStructure
 * @Author Hannibal
 * @Package org.example.mediator.impl
 * @Date 06/08/2023 10:39
 * @Description: TODO Concrete Mediator
 */
public class MediatorStructure extends Mediator {

    private HouseOwner houseOwner ;
    private Tenant tenant ;

    public HouseOwner getHouseOwner() {
        return houseOwner;
    }

    public void setHouseOwner(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    @Override
    public void contact(String message, Person person) {
        if (person == houseOwner) {
            tenant.getMessage(message);
        } else {
            houseOwner.getMessage(message);
        }
    }
}
