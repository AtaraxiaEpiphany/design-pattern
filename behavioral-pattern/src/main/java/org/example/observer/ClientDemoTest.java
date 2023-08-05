package org.example.observer;

import org.example.observer.impl.SubscriptionSubject;
import org.example.observer.impl.WechatUser;
import org.junit.jupiter.api.Test;

/**
 * @Title: ClientDemoTest
 * @Author Hannibal
 * @Package org.example.observer
 * @Date 05/08/2023 22:44
 * @Description: TODO
 */
public class ClientDemoTest {
    @Test
    public void test() {
        Subject subject = new SubscriptionSubject();
        Observer o1 = new WechatUser("Hannibal");
        Observer o2 = new WechatUser("Ataraxia");
        Observer o3 = new WechatUser("Epiphany");
        Observer o4 = new WechatUser("Tulip");
        subject.attach(o1);
        subject.attach(o2);
        subject.attach(o3);
        subject.attach(o4);

        subject.notify("Hello Observer!");

    }

    @Test
    void name() {
    }
}
