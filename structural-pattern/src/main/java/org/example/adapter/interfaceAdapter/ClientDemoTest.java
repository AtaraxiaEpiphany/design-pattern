package org.example.adapter.interfaceAdapter;

import org.example.adapter.objectAdapter.Computer;
import org.example.adapter.objectAdapter.SDCard;
import org.example.adapter.objectAdapter.SDCardAdapterTF;
import org.example.adapter.objectAdapter.TFCard;
import org.example.adapter.objectAdapter.impl.TFCardImpl;
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
        org.example.adapter.objectAdapter.Computer computer = new Computer();
        /**
         * 适配TF卡
         */
        TFCard tfCard = new TFCardImpl();
        SDCard sdAdapter = new SDCardAdapterTF(tfCard);
        computer.readFromSD(sdAdapter);
        computer.write2SD(sdAdapter);

    }
}
