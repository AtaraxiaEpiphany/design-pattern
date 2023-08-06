package org.example.mediator;

import org.example.mediator.impl.HouseOwner;
import org.example.mediator.impl.MediatorStructure;
import org.example.mediator.impl.Tenant;
import org.junit.jupiter.api.Test;

/**
 * @Title: ClientDemoTest
 * @Author Hannibal
 * @Package org.example.mediator
 * @Date 06/08/2023 10:46
 * @Description: TODO
 */
public class ClientDemoTest {
    @Test
    public void test() {
        MediatorStructure mediator = new MediatorStructure();
        HouseOwner houseOwner = new HouseOwner("Hannibal", mediator);
        Tenant tenant = new Tenant("Ataraxia", mediator);
        //建立中介者与对象间的关系
        mediator.setHouseOwner(houseOwner);
        mediator.setTenant(tenant);

        tenant.contact("三室一厅...");
        houseOwner.contact("出租三室房间...");
    }
}
