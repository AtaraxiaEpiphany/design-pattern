package org.example.adapter.classAdapter;

import org.example.adapter.classAdapter.impl.TFCardImpl;

import static com.common.util.LogUtil.FG_BLUE;

/**
 * @Title: SDCardAdapterTF SD卡的适配器
 * @Author Hannibal
 * @Package org.example.adapter.classAdapter
 * @Date 29/07/2023 10:56
 * @Description: 适配器, 适配TF卡为SD卡.
 */
public class SDCardAdapterTF extends TFCardImpl implements SDCard {

    @Override
    public String readSD() {
        FG_BLUE.print("Read from class adapter...");
        return readTF();
    }

    @Override
    public void write2SD(String data) {
        FG_BLUE.print("Write in class adapter...");
        write2TF(data);
    }
}
