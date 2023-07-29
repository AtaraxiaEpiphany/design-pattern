package org.example.adapter.interfaceAdapter;

import static com.common.util.LogUtil.FG_BLUE;

/**
 * @Title: SDCardAdapterTF SD卡的适配器
 * @Author Hannibal
 * @Package org.example.adapter.classAdapter
 * @Date 29/07/2023 10:56
 * @Description: 适配器, 适配TF卡为SD卡.
 */
public class SDCardSDAdapterTF extends SDAdapter {

    private TFCard tfCard;

    public SDCardSDAdapterTF(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    /**
     * 按需重写
     *
     * @return
     */
    @Override
    public String readSD() {
        FG_BLUE.print("Read from interface adapter...");
        return tfCard.readTF();
    }

    @Override
    public void write2SD(String data) {
        FG_BLUE.print("Write in interface adapter...");
        tfCard.write2TF(data);
    }
}
