package org.example.adapter.classAdapter;

import org.example.adapter.classAdapter.impl.SDCardImpl;
import org.junit.jupiter.api.Test;

/**
 * @Title: ClientDemoTest
 * @Author Hannibal
 * @Package org.example.adapter
 * @Date 29/07/2023 11:00
 * @Description: TODO
 */
public class ClientDemoTest {
    @Test
    public void testClassAdapter() {
        Computer computer = new Computer();
        SDCard sdCard = new SDCardImpl();
        computer.readFromSD(sdCard);
        computer.write2SD(sdCard);
        System.out.println("===========================");
        SDCard sdAdapter = new SDCardAdapterTF();
        computer.readFromSD(sdAdapter);
        computer.write2SD(sdAdapter);
    }
}
