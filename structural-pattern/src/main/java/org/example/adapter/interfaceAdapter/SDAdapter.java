package org.example.adapter.interfaceAdapter;

/**
 * @Title: Adapter 适配器接口
 * @Author Hannibal
 * @Package org.example.adapter.interfaceAdapter
 * @Date 29/07/2023 11:43
 * @Description: 默认实现目标接口, 并给所有方法空实现.
 */
public abstract class SDAdapter implements SDCard {
    /**
     * 空实现.
     */
    @Override
    public String readSD() {
        return null;
    }

    @Override
    public void write2SD(String data) {
    }

    @Override
    public void someOtherMethod() {

    }

    @Override
    public void redundantMethod() {

    }
}
