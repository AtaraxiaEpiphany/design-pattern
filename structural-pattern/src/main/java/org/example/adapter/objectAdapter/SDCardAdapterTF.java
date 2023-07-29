package org.example.adapter.objectAdapter;

import static com.common.util.LogUtil.FG_BLUE;

/**
 * @Title: SDCardAdapterTF SD卡的适配器
 * @Author Hannibal
 * @Package org.example.adapter.classAdapter
 * @Date 29/07/2023 10:56
 * @Description: 适配器, 适配TF卡为SD卡.
 */
public class SDCardAdapterTF implements SDCard {

    private TFCard tfCard;

    public SDCardAdapterTF(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public String readSD() {
        FG_BLUE.print("Read from object adapter...");
        return tfCard.readTF();
    }

    @Override
    public void write2SD(String data) {
        FG_BLUE.print("Write in object adapter...");
        tfCard.write2TF(data);
    }
}
