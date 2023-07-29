package org.example.adapter.classAdapter;

/**
 * @Title: SDCard SD卡接口
 * @Author Hannibal
 * @Package org.example.adapter.classAdapter
 * @Date 29/07/2023 10:51
 * @Description: TODO 目标接口
 */
public interface SDCard {
    String readSD();

    void write2SD(String data);
}
