package org.example.adapter.interfaceAdapter;

/**
 * @Title: TFCard TF卡
 * @Author Hannibal
 * @Package org.example.adapter.classAdapter
 * @Date 29/07/2023 10:46
 * @Description: 适配者接口
 */
public interface TFCard {
    String readTF();

    void write2TF(String data);
}
