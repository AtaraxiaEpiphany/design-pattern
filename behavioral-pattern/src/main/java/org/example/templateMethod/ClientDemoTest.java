package org.example.templateMethod;

import org.example.templateMethod.impl.ConcreteClass_BaoCai;
import org.example.templateMethod.impl.ConcreteClass_CaiXin;
import org.junit.jupiter.api.Test;

/**
 * @Title: ClientDemoTest
 * @Author Hannibal
 * @Package org.example.templateMethod
 * @Date 01/08/2023 22:04
 * @Description: TODO
 */
public class ClientDemoTest {
    @Test
    public void test(){
        AbstractClass baoCai = new ConcreteClass_BaoCai();
        AbstractClass caiXin = new ConcreteClass_CaiXin();
        baoCai.coolProcess();
        System.out.println("============");
        caiXin.coolProcess();
    }
}
