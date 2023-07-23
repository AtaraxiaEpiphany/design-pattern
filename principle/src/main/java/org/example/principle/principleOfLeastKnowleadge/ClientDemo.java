package org.example.principle.principleOfLeastKnowleadge;

import org.junit.jupiter.api.Test;

/**
 * @Title: ClientDemo
 * @Author Hannibal
 * @Package org.example.principle.principleOfLeastKnowleadge
 * @Date 23/07/2023 15:21
 * @Description: TODO
 */
public class ClientDemo {
    @Test
    public void test() {
        Agent agent = new Agent();
        agent.setStar(new Star("林青霞"));
        agent.setFans(new Fans("猪仔"));
        agent.setCompany(new Company("传媒公司"));

        agent.meetFans();
        agent.business();
    }
}
